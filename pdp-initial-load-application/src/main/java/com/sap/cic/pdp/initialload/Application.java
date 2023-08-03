package com.sap.cic.pdp.initialload;

import com.sap.cic.pdp.initialload.config.Configuration;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

import java.util.Objects;

import static com.sap.cic.pdp.initialload.constants.BlobStorageConstants.*;
import static com.sap.cic.pdp.initialload.constants.PropertyConstants.CONFIG_YAML_FILE;
import static com.sap.cic.pdp.initialload.utils.ConfigLoadUtils.getConfiguration;


public class Application {
    public static void main(String[] args) {

        String profile = (args.length > 0 ? args[0] : null);
        final Configuration config = getConfiguration(CONFIG_YAML_FILE);
//        log.debug("Config : {}", config);

        if (Objects.nonNull(config)) {
            SparkConf conf = getSparkConf(config, profile);

            try (
                    SparkSession session = SparkSession.builder().config(conf).getOrCreate()
            ) {
//                Producer<String, InitialUploadStatusEventEo> kafkaProducer =
//                        InitialUploadStatusEventEoKafkaProducerFactory.build(config.getKafka());
//                processData(profile, config, session, kafkaProducer);
            }

        }
    }

//        SparkSession spark = SparkSession
//                .builder()
//                .appName("crp-dl-stream")
//                .master("local[*]")
//                .getOrCreate();
//
//        spark.close();


        private static SparkConf getSparkConf (Configuration config, String profile){
            SparkConf conf = new SparkConf();
            conf.setAppName(config.getSpark().getAppName());
            conf.set(String.format(ACCOUNT_AUTH_TYPE, config.getBlobStorage().getAccountName()), OAUTH);
            conf.set(String.format(OAUTH_PROVIDER, config.getBlobStorage().getAccountName()),
                    CLIENT_CREDS_TOKEN_PROVIDER);
            conf.set(String.format(BLOB_AUTH_CLIENT_ID, config.getBlobStorage().getAccountName()),
                    config.getBlobStorage().getClientId());
            conf.set(String.format(BLOB_AUTH_CLIENT_SECRET, config.getBlobStorage().getAccountName()),
                    config.getBlobStorage().getClientSecret());
            conf.set(String.format(BLOB_AUTH_CLIENT_ENDPOINT, config.getBlobStorage().getAccountName()),
                    String.format(OAUTH_URL, config.getBlobStorage().getDirectoryId()));
            conf.set(WRITE_AHEAD_LOG, TRUE);
            conf.set(BACKPRESSURE, TRUE);
            conf.set(DRIVER_WRITE_AHEAD_LOG, TRUE);
            conf.set(RECEIVER_WRITE_AHEAD_LOG, TRUE);

//        if (PROFILE_LOCAL.equals(profile)) {
//            conf.setMaster(config.getSpark().getMaster());
//        }

            return conf;
        }

}
