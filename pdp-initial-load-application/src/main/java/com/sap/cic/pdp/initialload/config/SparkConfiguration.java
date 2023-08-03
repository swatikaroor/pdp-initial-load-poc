
package com.sap.cic.pdp.initialload.config;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>This is the bo class for Spark Configuration.</p>
 */
@Data
@NoArgsConstructor
public class SparkConfiguration {

    private String appName;

    private String master;

    private Long streamingDuration;

    private String mode;

}
