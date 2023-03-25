/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.iot.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for DeviceManager client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.iot.v1.device-manager")
public class DeviceManagerSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials(
          "https://www.googleapis.com/auth/cloud-platform",
          "https://www.googleapis.com/auth/cloudiot");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for createDeviceRegistry. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createDeviceRegistryRetry;
  /**
   * Allow override of retry settings at method-level for getDeviceRegistry. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getDeviceRegistryRetry;
  /**
   * Allow override of retry settings at method-level for updateDeviceRegistry. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateDeviceRegistryRetry;
  /**
   * Allow override of retry settings at method-level for deleteDeviceRegistry. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteDeviceRegistryRetry;
  /**
   * Allow override of retry settings at method-level for listDeviceRegistries. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listDeviceRegistriesRetry;
  /**
   * Allow override of retry settings at method-level for createDevice. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createDeviceRetry;
  /**
   * Allow override of retry settings at method-level for getDevice. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getDeviceRetry;
  /**
   * Allow override of retry settings at method-level for updateDevice. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateDeviceRetry;
  /**
   * Allow override of retry settings at method-level for deleteDevice. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteDeviceRetry;
  /**
   * Allow override of retry settings at method-level for listDevices. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listDevicesRetry;
  /**
   * Allow override of retry settings at method-level for modifyCloudToDeviceConfig. If defined,
   * this takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry modifyCloudToDeviceConfigRetry;
  /**
   * Allow override of retry settings at method-level for listDeviceConfigVersions. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listDeviceConfigVersionsRetry;
  /**
   * Allow override of retry settings at method-level for listDeviceStates. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listDeviceStatesRetry;
  /**
   * Allow override of retry settings at method-level for setIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRetry;
  /**
   * Allow override of retry settings at method-level for sendCommandToDevice. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry sendCommandToDeviceRetry;
  /**
   * Allow override of retry settings at method-level for bindDeviceToGateway. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry bindDeviceToGatewayRetry;
  /**
   * Allow override of retry settings at method-level for unbindDeviceFromGateway. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry unbindDeviceFromGatewayRetry;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public boolean getUseRest() {
    return this.useRest;
  }

  public void setUseRest(boolean useRest) {
    this.useRest = useRest;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Retry getRetry() {
    return this.retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public Retry getCreateDeviceRegistryRetry() {
    return this.createDeviceRegistryRetry;
  }

  public void setCreateDeviceRegistryRetry(Retry createDeviceRegistryRetry) {
    this.createDeviceRegistryRetry = createDeviceRegistryRetry;
  }

  public Retry getGetDeviceRegistryRetry() {
    return this.getDeviceRegistryRetry;
  }

  public void setGetDeviceRegistryRetry(Retry getDeviceRegistryRetry) {
    this.getDeviceRegistryRetry = getDeviceRegistryRetry;
  }

  public Retry getUpdateDeviceRegistryRetry() {
    return this.updateDeviceRegistryRetry;
  }

  public void setUpdateDeviceRegistryRetry(Retry updateDeviceRegistryRetry) {
    this.updateDeviceRegistryRetry = updateDeviceRegistryRetry;
  }

  public Retry getDeleteDeviceRegistryRetry() {
    return this.deleteDeviceRegistryRetry;
  }

  public void setDeleteDeviceRegistryRetry(Retry deleteDeviceRegistryRetry) {
    this.deleteDeviceRegistryRetry = deleteDeviceRegistryRetry;
  }

  public Retry getListDeviceRegistriesRetry() {
    return this.listDeviceRegistriesRetry;
  }

  public void setListDeviceRegistriesRetry(Retry listDeviceRegistriesRetry) {
    this.listDeviceRegistriesRetry = listDeviceRegistriesRetry;
  }

  public Retry getCreateDeviceRetry() {
    return this.createDeviceRetry;
  }

  public void setCreateDeviceRetry(Retry createDeviceRetry) {
    this.createDeviceRetry = createDeviceRetry;
  }

  public Retry getGetDeviceRetry() {
    return this.getDeviceRetry;
  }

  public void setGetDeviceRetry(Retry getDeviceRetry) {
    this.getDeviceRetry = getDeviceRetry;
  }

  public Retry getUpdateDeviceRetry() {
    return this.updateDeviceRetry;
  }

  public void setUpdateDeviceRetry(Retry updateDeviceRetry) {
    this.updateDeviceRetry = updateDeviceRetry;
  }

  public Retry getDeleteDeviceRetry() {
    return this.deleteDeviceRetry;
  }

  public void setDeleteDeviceRetry(Retry deleteDeviceRetry) {
    this.deleteDeviceRetry = deleteDeviceRetry;
  }

  public Retry getListDevicesRetry() {
    return this.listDevicesRetry;
  }

  public void setListDevicesRetry(Retry listDevicesRetry) {
    this.listDevicesRetry = listDevicesRetry;
  }

  public Retry getModifyCloudToDeviceConfigRetry() {
    return this.modifyCloudToDeviceConfigRetry;
  }

  public void setModifyCloudToDeviceConfigRetry(Retry modifyCloudToDeviceConfigRetry) {
    this.modifyCloudToDeviceConfigRetry = modifyCloudToDeviceConfigRetry;
  }

  public Retry getListDeviceConfigVersionsRetry() {
    return this.listDeviceConfigVersionsRetry;
  }

  public void setListDeviceConfigVersionsRetry(Retry listDeviceConfigVersionsRetry) {
    this.listDeviceConfigVersionsRetry = listDeviceConfigVersionsRetry;
  }

  public Retry getListDeviceStatesRetry() {
    return this.listDeviceStatesRetry;
  }

  public void setListDeviceStatesRetry(Retry listDeviceStatesRetry) {
    this.listDeviceStatesRetry = listDeviceStatesRetry;
  }

  public Retry getSetIamPolicyRetry() {
    return this.setIamPolicyRetry;
  }

  public void setSetIamPolicyRetry(Retry setIamPolicyRetry) {
    this.setIamPolicyRetry = setIamPolicyRetry;
  }

  public Retry getGetIamPolicyRetry() {
    return this.getIamPolicyRetry;
  }

  public void setGetIamPolicyRetry(Retry getIamPolicyRetry) {
    this.getIamPolicyRetry = getIamPolicyRetry;
  }

  public Retry getTestIamPermissionsRetry() {
    return this.testIamPermissionsRetry;
  }

  public void setTestIamPermissionsRetry(Retry testIamPermissionsRetry) {
    this.testIamPermissionsRetry = testIamPermissionsRetry;
  }

  public Retry getSendCommandToDeviceRetry() {
    return this.sendCommandToDeviceRetry;
  }

  public void setSendCommandToDeviceRetry(Retry sendCommandToDeviceRetry) {
    this.sendCommandToDeviceRetry = sendCommandToDeviceRetry;
  }

  public Retry getBindDeviceToGatewayRetry() {
    return this.bindDeviceToGatewayRetry;
  }

  public void setBindDeviceToGatewayRetry(Retry bindDeviceToGatewayRetry) {
    this.bindDeviceToGatewayRetry = bindDeviceToGatewayRetry;
  }

  public Retry getUnbindDeviceFromGatewayRetry() {
    return this.unbindDeviceFromGatewayRetry;
  }

  public void setUnbindDeviceFromGatewayRetry(Retry unbindDeviceFromGatewayRetry) {
    this.unbindDeviceFromGatewayRetry = unbindDeviceFromGatewayRetry;
  }
}
