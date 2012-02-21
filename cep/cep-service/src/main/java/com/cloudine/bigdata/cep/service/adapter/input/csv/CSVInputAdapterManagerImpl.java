package com.cloudine.bigdata.cep.service.adapter.input.csv;

import com.cloudine.bigdata.cep.service.adapter.AbstractAdapterManagerImpl;
import com.cloudine.bigdata.cep.service.utils.DataTypeResolver;
import com.espertech.esper.adapter.InputAdapter;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.espertech.esperio.csv.CSVInputAdapterSpec;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * CSV Input Adapter Manager Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CSVInputAdapterManagerImpl extends AbstractAdapterManagerImpl {

    /**
     * SLF4J Logging
     */
    private Logger logger = LoggerFactory.getLogger(CSVInputAdapterManagerImpl.class);

    private CSVInputAdapterSpec spec;

    private InputAdapter inputAdapter;

    /**
     * Input file path.
     */
    private String resource;

    private String stream;

    private String fieldNames;

    private String fieldTypes;

    @Override
    public void start() throws Exception {

        logger.info("[{}] CSV Input Adapter Starting..................", cepEngineID);

        try {

            cepServiceEngine = EPServiceProviderManager.getProvider(cepEngineID);

            spec = new CSVInputAdapterSpec(new AdapterInputSource(new File(resource)), stream);
            String[] propertyOrder = StringUtils.splitByWholeSeparatorPreserveAllTokens(fieldNames, ",");
            spec.setPropertyOrder(propertyOrder);
//            spec.setPropertyTypes(this.getEventTypesMap(fieldNames, fieldTypes));
            spec.setEventsPerSec(1);
            spec.setLooping(true);
            // Set to true to use the engine timer thread for the work, or false to use the current thread.
            spec.setUsingEngineThread(true);

            inputAdapter = new CSVInputAdapter(cepServiceEngine, spec);
//            inputAdapter = new CSVInputAdapter(cepServiceEngine, new AdapterInputSource(new File(resource)), stream);


            inputAdapter.start();

        } catch (Exception e) {
            String message = "[" + cepEngineID + "] CSV Input Adapter Failed to start: ";
            logger.error(message, e);
            logger.error("resource= {}", resource);
            logger.error("stream= {}", stream);
            logger.error("fieldNames= {}", fieldNames);
            logger.error("fieldTypes= {}", fieldTypes);
            throw new Exception(message, e);
        }

        state = "ACTIVE";

        logger.info("[{}] CSV Input Adapter Started successfully.", cepEngineID);
    }

    @Override
    public void stop() throws Exception {

        logger.info("[{}] CSV Input Adapter Stopping..................", cepEngineID);

        if (inputAdapter != null) {
            inputAdapter.destroy();
        }
        spec = null;

        state = "STOPPED";

        logger.info("[{}] CSV Input Adapter Stopped successfully", cepEngineID);
    }

    public Map<String, Object> getEventTypesMap(String fieldNames, String fieldTypes) {
        Map<String, Object> rsMap = new HashMap<String, Object>();
        String[] fields = StringUtils.splitByWholeSeparatorPreserveAllTokens(fieldNames, ",");
        String[] dataTypes = StringUtils.splitByWholeSeparatorPreserveAllTokens(fieldTypes, ",");

        for (int i = 0; i < fields.length; i++) {
            rsMap.put(fields[i], DataTypeResolver.getDataTypeByKey(dataTypes[i]));
        }
        return rsMap;
    }


    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getResource() {
        return resource;
    }

    public String getStream() {
        return stream;
    }

    public String getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(String fieldNames) {
        this.fieldNames = fieldNames;
    }

    public String getFieldTypes() {
        return fieldTypes;
    }

    public void setFieldTypes(String fieldTypes) {
        this.fieldTypes = fieldTypes;
    }
}
