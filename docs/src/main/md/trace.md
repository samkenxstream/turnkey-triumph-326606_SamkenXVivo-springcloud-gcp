## Cloud Trace

Google Cloud provides a managed distributed tracing service
called [Cloud Trace](https://cloud.google.com/trace/), and [Micrometer](https://micrometer.io/) can be used with
it to easily instrument Spring Boot applications for observability.

Typically, Micrometer captures trace information and forwards
traces to service like Zipkin for storage and analysis. However, on
Google Cloud, instead of running and maintaining your own Zipkin instance and
storage, you can use Cloud Trace to store traces, view trace details,
generate latency distributions graphs, and generate performance
regression reports.

This Spring Framework on Google Cloud starter can forward Micrometer traces to
Cloud Trace without an intermediary Zipkin server.

Maven coordinates,
using [Spring Framework on Google Cloud BOM](getting-started.xml#bill-of-materials):

``` xml
<dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>spring-cloud-gcp-starter-trace</artifactId>
</dependency>
```

Gradle coordinates:

    dependencies {
        implementation("com.google.cloud:spring-cloud-gcp-starter-trace")
    }

You must enable Cloud Trace API from the Google Cloud Console in order
to capture traces. Navigate to the [Cloud Trace
API](https://console.cloud.google.com/apis/api/cloudtrace.googleapis.com/overview)
for your project and make sure it’s enabled.

<div class="note">

If you are already using a Zipkin server capturing trace information
from multiple platform/frameworks, you can also use a [Stackdriver
Zipkin proxy](https://cloud.google.com/trace/docs/zipkin) to forward
those traces to Cloud Trace without modifying existing applications.

</div>

### Tracing

Micrometer uses the [Brave
tracer](https://github.com/openzipkin/brave) to generate traces. This
integration enables Brave to use the
[`StackdriverTracePropagation`](https://github.com/openzipkin/zipkin-gcp/tree/main/propagation-stackdriver)
propagation.

A propagation is responsible for extracting trace context from an entity
(e.g., an HTTP servlet request) and injecting trace context into an
entity. A canonical example of the propagation usage is a web server
that receives an HTTP request, which triggers other HTTP requests from
the server before returning an HTTP response to the original caller. In
the case of `StackdriverTracePropagation`, first it looks for trace
context in the `x-cloud-trace-context` key (e.g., an HTTP request
header). The value of the `x-cloud-trace-context` key can be formatted
in three different ways:

  - `x-cloud-trace-context: TRACE_ID`

  - `x-cloud-trace-context: TRACE_ID/SPAN_ID`

  - `x-cloud-trace-context: TRACE_ID/SPAN_ID;o=TRACE_TRUE`

`TRACE_ID` is a 32-character hexadecimal value that encodes a 128-bit
number.

`SPAN_ID` is an unsigned long. Since Cloud Trace doesn't support span
joins, a new span ID is always generated, regardless of the one
specified in `x-cloud-trace-context`.

`TRACE_TRUE` can either be `0` if the entity should be untraced, or `1`
if it should be traced. This field forces the decision of whether
to trace the request; if omitted then the decision is deferred to the
sampler.

If a `x-cloud-trace-context` key isn’t found,
`StackdriverTracePropagation` falls back to tracing with the [X-B3
headers](https://github.com/openzipkin/b3-propagation).

### Spring Boot Starter for Cloud Trace

Spring Boot Starter for Cloud Trace uses Micrometer and
autoconfigures a
[StackdriverSender](https://github.com/openzipkin/zipkin-gcp/blob/main/sender-stackdriver/src/main/java/zipkin2/reporter/stackdriver/StackdriverSender.java)
that sends the Micrometer’s trace information to Cloud Trace.

All configurations are optional:

|                                                     |                                                                                                                                  |          |               |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- | -------- | ------------- |
| Name                                                | Description                                                                                                                      | Required | Default value |
| `spring.cloud.gcp.trace.enabled`                    | Auto-configure Micrometer to send traces to Cloud Trace.                                                                | No       | `true`        |
| `spring.cloud.gcp.trace.project-id`                 | Overrides the project ID from the [Spring Framework on Google Cloud Module](#spring-framework-on-google-cloud-core)                                              | No       |               |
| `spring.cloud.gcp.trace.credentials.location`       | Overrides the credentials location from the [Spring Framework on Google Cloud Module](#spring-framework-on-google-cloud-core)                                    | No       |               |
| `spring.cloud.gcp.trace.credentials.encoded-key`    | Overrides the credentials encoded key from the [Spring Framework on Google Cloud Module](#spring-framework-on-google-cloud-core)                                 | No       |               |
| `spring.cloud.gcp.trace.credentials.scopes`         | Overrides the credentials scopes from the [Spring Framework on Google Cloud Module](#spring-framework-on-google-cloud-core)                                      | No       |               |
| `spring.cloud.gcp.trace.num-executor-threads`       | Number of threads used by the Trace executor                                                                                     | No       | 4             |
| `spring.cloud.gcp.trace.authority`                  | HTTP/2 authority the channel claims to be connecting to.                                                                         | No       |               |
| `spring.cloud.gcp.trace.compression`                | Name of the compression to use in Trace calls                                                                                    | No       |               |
| `spring.cloud.gcp.trace.deadline-ms`                | Call deadline in milliseconds                                                                                                    | No       |               |
| `spring.cloud.gcp.trace.max-inbound-size`           | Maximum size for inbound messages                                                                                                | No       |               |
| `spring.cloud.gcp.trace.max-outbound-size`          | Maximum size for outbound messages                                                                                               | No       |               |
| `spring.cloud.gcp.trace.wait-for-ready`             | [Waits for the channel to be ready](https://github.com/grpc/grpc/blob/main/doc/wait-for-ready.md) in case of a transient failure | No       | `false`       |
| `spring.cloud.gcp.trace.messageTimeout`             | Timeout in seconds before pending spans will be sent in batches to GCP Cloud Trace. (previously `spring.zipkin.messageTimeout`)  | No       | 1             |
| `spring.cloud.gcp.trace.server-response-timeout-ms` | Server response timeout in millis.                                                                                               | No       | `5000`        |
| `spring.cloud.gcp.trace.pubsub.enabled`             | (Experimental) Auto-configure Pub/Sub instrumentation for Trace.                                                                 | No       | `false`       |

You can use core Micrometer properties to control Micrometer’s
sampling rate, etc. Read [Spring Boot Tracing documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.micrometer-tracing) for more
information on Micrometer configurations.

For example, when you are testing to see the traces are going through,
you can set the sampling rate to 100%.

    management.tracing.sampling.probability=1.0              # Send 100% of the request traces to Cloud Trace.

Spring Framework on Google Cloud Trace does override some Micrometer configurations:

  - Always uses 128-bit Trace IDs. This is required by Cloud Trace.

  - Does not use Span joins. Span joins will share the span ID between
    the client and server Spans. Cloud Trace requires that every Span ID
    within a Trace to be unique, so Span joins are not supported.

### Overriding the autoconfiguration

You can send traces to multiple tracing systems. In order to get this to work, every tracing system
needs to have a `Reporter<Span>` and `Sender`. If you want to override
the provided beans you need to give them a specific name. To do this you
can use respectively
`StackdriverTraceAutoConfiguration.REPORTER_BEAN_NAME` and
`StackdriverTraceAutoConfiguration.SENDER_BEAN_NAME`.

### Customizing spans

You can add additional tags and annotations to spans by using the
`brave.SpanCustomizer`, which is available in the application context.

Here’s an example that uses `WebMvcConfigurer` to configure an MVC
interceptor that adds two extra tags to all web controller spans.

``` java
@SpringBootApplication
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SpanCustomizer spanCustomizer;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                spanCustomizer.tag("session-id", request.getSession().getId());
                spanCustomizer.tag("environment", "QA");

                return true;
            }
        });
    }
}
```

You can then search and filter traces based on these additional tags in
the Cloud Trace service.

### Integration with Logging

Integration with Cloud Logging is available through the [Cloud Logging
Support](#cloud-logging). If the Trace integration is used together with
the Logging one, the request logs will be associated to the
corresponding traces. The trace logs can be viewed by going to the
[Google Cloud Console Trace
List](https://console.cloud.google.com/traces/traces), selecting a trace
and pressing the `Logs → View` link in the `Details` section.

### Pub/Sub Trace Instrumentation (Experimental)

You can enable trace instrumentation and propagation for Pub/Sub
messages by using the `spring.cloud.gcp.trace.pubsub.enabled=true`
property. It’s set to `false` by default, but when set to `true`, trace
spans will be created and propagated to Cloud Trace whenever the
application sends or receives messages through `PubSubTemplate` or any
other integration that builds on top of `PubSubTemplate`, such as the
Spring Integration channel adapters, and the Spring Cloud Stream Binder.

    # Enable Pub/Sub tracing using this property
    spring.cloud.gcp.trace.pubsub.enabled=true

### Sample

A [sample
application](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/main/spring-cloud-gcp-samples/spring-cloud-gcp-trace-sample)
and a
[codelab](https://codelabs.developers.google.com/codelabs/cloud-spring-cloud-gcp-trace/index.html)
are available.
