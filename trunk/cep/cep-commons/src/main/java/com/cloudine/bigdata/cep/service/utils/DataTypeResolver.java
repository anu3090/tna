package com.cloudine.bigdata.cep.service.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Data Type Resolver Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class DataTypeResolver {

    private static Map<String, Object> dataTypeMap = new HashMap<String, Object>();

    static {
        dataTypeMap.put("String", String.class);
        dataTypeMap.put("int", Integer.class);
        dataTypeMap.put("double", Double.class);
        dataTypeMap.put("long", Long.class);
        dataTypeMap.put("float", Float.class);
    }

    /**
     * Get Data Type with key
     *
     * @param key key
     * @return DataType Object
     */
    public static Object getDataTypeByKey(String key) {
        return dataTypeMap.get(key);
    }
}
