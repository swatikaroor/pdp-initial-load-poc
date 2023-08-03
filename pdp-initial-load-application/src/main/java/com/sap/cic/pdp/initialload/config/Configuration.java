package com.sap.cic.pdp.initialload.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>This class gets configuration from config yaml.</p>
 */
@Data
@NoArgsConstructor
public class Configuration {

//  private DatabaseCredentials postgres;

    private SparkConfiguration spark;

//  private KafkaCredentials kafka;

    private BlobStorage blobStorage;

    private List<Entity> entities;

    private List<String> dropColumns;
}
