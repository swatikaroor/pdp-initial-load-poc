/*
 * ************************************************************************
 *  (C) 2022 SAP SE or an SAP affiliate company. All rights reserved. *
 * ************************************************************************
 */

package com.sap.cic.pdp.initialload.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>This class contains constants for BlobStorage. </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlobStorageConstants {

  public static final String BLOB_AUTH_CLIENT_ID
      = "fs.azure.account.oauth2.client.id.%s.dfs.core.windows.net";

  public static final String BLOB_AUTH_CLIENT_SECRET
      = "fs.azure.account.oauth2.client.secret.%s.dfs.core.windows.net";

  public static final String BLOB_AUTH_CLIENT_ENDPOINT
      = "fs.azure.account.oauth2.client.endpoint.%s.dfs.core.windows.net";

  public static final String OAUTH_URL = "https://login.microsoftonline.com/%s/oauth2/v2.0/token";

  public static final String OAUTH_PROVIDER
      = "fs.azure.account.oauth.provider.type.%s.dfs.core.windows.net";
  public static final String SCHEMA_FILE_PATH = "/cornerstone/%s/%s.asvc";

  public static final String ACCOUNT_AUTH_TYPE
      = "fs.azure.account.auth.type.%s.dfs.core.windows.net";

  public static final String OAUTH = "OAuth";

  public static final String CLUSTER = "CLUSTER";

  public static final String NAMESPACE = "NAMESPACE";

  public static final String CLIENT_CREDS_TOKEN_PROVIDER
      = "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider";

  public static final String WRITE_AHEAD_LOG
      = "spark.streaming.receiver.writeAheadLog.enable";

  public static final String TRUE = "true";
  public static final String TRIGGER_INITIAL_LOAD = "triggerInitialLoad";
  public static final String ACTIVITY_STATUS_UPDATE = "statusUpdateInitialLoad";

  public static final String BACKPRESSURE = "spark.streaming.backpressure.enabled";

  public static final String DRIVER_WRITE_AHEAD_LOG
      = "spark.streaming.driver.writeAheadLog.closeFileAfterWrite";

  public static final String RECEIVER_WRITE_AHEAD_LOG
      = "spark.streaming.receiver.writeAheadLog.closeFileAfterWrite";
}
