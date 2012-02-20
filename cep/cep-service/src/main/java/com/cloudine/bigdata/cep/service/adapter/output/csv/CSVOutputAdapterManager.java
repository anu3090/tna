package com.cloudine.bigdata.cep.service.adapter.output.csv;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.util.Assert.notNull;

/**
 * CSV Output Adapter Manager Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CSVOutputAdapterManager implements CSVOutputAdapterManagerMBean {

    /**
     * SLF4J Logging.
     */
    private Logger logger = LoggerFactory.getLogger(CSVOutputAdapterManager.class);

    /**
     * CEP Engine ID.
     */
    private String cepEngineID;

    /**
     * CEP Engine reference.
     */
    private EPServiceProvider cepServiceEngine;

    /**
     * Current State.
     * <p/>
     * STOPPED, ACTIVE
     */
    private String state = "STOPPED";

    private String statementName;

    private EPStatement epStatement;

    private String fieldNames;

    private CSVOutputAdapterUpdateListener listener;

    public void start() throws Exception {

        logger.info("[{}] CSV Output Adapter Starting...", cepEngineID);

        cepServiceEngine = EPServiceProviderManager.getProvider(cepEngineID);

        epStatement = cepServiceEngine.getEPAdministrator().getStatement(statementName);

        notNull(epStatement, "There is no EPL Statement for " + statementName);

        listener = new CSVOutputAdapterUpdateListener();
        epStatement.addListener(listener);

        state = "ACTIVE";

        logger.info("[{}] CSV Output Adapter Started successfully.", cepEngineID);
    }

    public void stop() throws Exception {

        logger.info("[{}] CSV Output Adapter Stopping...", cepEngineID);

        if (epStatement != null && !epStatement.isDestroyed()) {
            epStatement.removeListener(listener);
            listener = null;
            logger.debug("Listener is removed successfully.");
        }

        state = "STOPPED";

        logger.info("[{}] CSV Output Adapter Stopped successfully.", cepEngineID);
    }

    public String getCepEngineID() {
        return cepEngineID;
    }

    public void setCepEngineID(String cepEngineID) {
        this.cepEngineID = cepEngineID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatementName() {
        return statementName;
    }

    public void setStatementName(String statementName) {
        this.statementName = statementName;
    }

    public String getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(String fieldNames) {
        this.fieldNames = fieldNames;
    }

    private class CSVOutputAdapterUpdateListener implements UpdateListener {

        public void update(EventBean[] newEvents, EventBean[] oldEvent) {

            logger.debug("newEvents.length= {}", newEvents.length);
            logger.debug("oldEvent.length= {}", oldEvent != null ? oldEvent.length : null);

            for (int i = 0; i < newEvents.length; i++) {
                logger.debug("Event Name: " + newEvents[i].getEventType().getName());

                String[] propertyNames = newEvents[i].getEventType().getPropertyNames();



                for(String propertyName : propertyNames) {
                    System.out.println(propertyName + "=" + newEvents[i].get(propertyName));
                }

            }
        }
    }

}
