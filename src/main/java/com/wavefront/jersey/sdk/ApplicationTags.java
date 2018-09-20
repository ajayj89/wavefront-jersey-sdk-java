package com.wavefront.jersey.sdk;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Metadata about your application represented as tags in Wavefront.
 *
 * @author Sushant Dewan (sushant@wavefront.com).
 */
public class ApplicationTags {
  private final String application;
  @Nullable
  private final String cluster;
  private final String service;
  @Nullable
  private final String shard;
  private final Map<String, String> customTags;

  public static class Builder {
    // Required parameters
    private final String application;
    private final String service;

    // Optional parameters
    @Nullable
    private String cluster;
    @Nullable
    private String shard;
    private Map<String, String> customTags = new HashMap<>();

    /**
     * Builder to build ApplicationTags.
     *
     * @param application Name of the application.
     * @param service     Name of the service.
     */
    public Builder(String application, String service) {
      this.application = application;
      this.service = service;
    }

    /**
     * Set the cluster (example: us-west-1/us-west-2 etc.) in which your application is running.
     * This setting is optional.
     *
     * @param cluster cluster in which your application is running.
     * @return {@code this}.
     */
    public Builder cluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    /**
     * Set the shard (example: primary/secondary etc.) in which your application is running.
     * This setting is optional.
     *
     * @param shard shard where your application is running.
     * @return {@code this}.
     */
    public Builder shard(String shard) {
      this.shard = shard;
      return this;
    }

    /**
     * Set additional custom tags for your application.
     * For instance: {location: SF}, {env: Staging} etc.
     * This setting is optional.
     *
     * @param customTags Additional custom tags/metadata for your application.
     * @return {@code this}
     */
    public Builder customTags(Map<String, String> customTags) {
      this.customTags = customTags;
      return this;
    }

    /**
     * Build application tags.
     *
     * @return {@link ApplicationTags}.
     */
    public ApplicationTags build() {
      return new ApplicationTags(this);
    }
  }

  private ApplicationTags(Builder builder) {
    application = builder.application;
    cluster = builder.cluster;
    service = builder.service;
    shard = builder.shard;
    customTags = builder.customTags;
  }

  /**
   * Fetch the application name.
   *
   * @return name of the application.
   */
  public String getApplication() {
    return application;
  }

  /**
   * Fetch the cluster name.
   *
   * @return name of the cluster.
   */
  @Nullable
  String getCluster() {
    return cluster;
  }

  /**
   * Fetch the service name
   *
   * @return name of the service
   */
  String getService() {
    return service;
  }

  /**
   * Fetch the shard name.
   *
   * @return name of the shard.
   */
  @Nullable
  String getShard() {
    return shard;
  }

  /**
   * Fetch the custom tags.
   *
   * @return custom tags.
   */
  @Nullable
  public Map<String, String> getCustomTags() {
    return customTags;
  }
}
