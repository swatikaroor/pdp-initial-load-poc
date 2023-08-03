/*
 * ************************************************************************
 *  (C) 2022 SAP SE or an SAP affiliate company. All rights reserved. *
 * ************************************************************************
 */

package com.sap.cic.pdp.initialload.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

/**
 * <p>This is a bo class for BlobStorage config.</p>
 */
@Data
public class BlobStorage {

  private static final String BLOB_PROPERTIES = "blob.properties";

  private String name;

  private String type;

  private String description;

  private String accountName;

  private String containerName;

  private String clientId;

  private String clientSecret;

  private String directoryId;

  private Properties blobProperties;

  private String abfssPath;

  private String containerPath;

  private String cluster;

  private String namespace;

  public BlobStorage() throws IOException {
    String property = System.getenv().get("BLOB_PROPERTIES_NAME");
    if (StringUtils.isNotBlank(property)) {
      this.blobProperties = new Properties();
      this.blobProperties.load(new StringReader(property));
    } else {
      this.blobProperties = new Properties();
      try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(BLOB_PROPERTIES)) {
        this.blobProperties.load(is);
      }
    }
  }

  public String getAccountName() {
    return getBlobProperties().getProperty("BLOB_ACCOUNTNAME", accountName);
  }

  public String getDirectoryId() {
    return getBlobProperties().getProperty("BLOB_DIRECTORYID", directoryId);
  }

  public String getClientId() {
    return getBlobProperties().getProperty("BLOB_CLIENTID", clientId);
  }

  public String getClientSecret() {
    return getBlobProperties().getProperty("BLOB_CLIENTSECRET", clientSecret);
  }

  public String getCluster() {
    return getBlobProperties().getProperty("CLUSTER", cluster);
  }

  public String getNamespace() {
    return getBlobProperties().getProperty("NAMESPACE", namespace);
  }

  public String getContainerName() {
    return getCluster() + "-" + getNamespace();
  }
}
