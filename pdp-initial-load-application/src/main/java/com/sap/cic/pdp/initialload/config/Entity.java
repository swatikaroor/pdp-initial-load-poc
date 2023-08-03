package com.sap.cic.pdp.initialload.config;

import lombok.Data;

/**
 * <p>This is the bo class for Entity details.</p>
 */
@Data
public class Entity {

    private String name;

    private boolean translationTable;

    private String tableName;

//    private ArrayList<FilterProperty> filterInboundProperties;
//
//    private ArrayList<FilterProperty> filterOutboundProperties;


}