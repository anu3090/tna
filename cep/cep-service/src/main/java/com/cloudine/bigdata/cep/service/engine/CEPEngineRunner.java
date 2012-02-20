package com.cloudine.bigdata.cep.service.engine;

import com.cloudine.bigdata.cep.service.event.OrderEvent;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * CEP Engine Runner Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPEngineRunner implements CEPEngineRunnerMBean {

    /**
     * SLF4J Logger.
     */
    private Logger logger = LoggerFactory.getLogger(CEPEngineRunner.class);

    /**
     * CEP Engine ID.
     */
    private String cepEngineID;

    /**
     * Current State.
     * <p/>
     * STOPPED, ACTIVE
     */
    private String state = "STOPPED";

    /**
     * Engine Start Time.
     * time in milliseconds
     */
    private long engineStartTime = 0L;

    /**
     * Engine Current Time.
     * time in milliseconds
     */
    private long currentEngineTime = System.currentTimeMillis();


    private EPServiceProvider cepServiceEngine;


    public void start() throws Exception {

        logger.info("[{}] CEP Engine Runner is starting..................", cepEngineID);

        /**
         * Engine Start.
         */
        engineStartTime = System.currentTimeMillis();

        /**
         * Create CEP Engine Instance
         */
        cepServiceEngine = EPServiceProviderManager.getProvider(
                cepEngineID, getEngineConfig());

        /**
         * Publish EPL Statement
         */
        String expression = "select Math.max(2, 3) as mymax, itemName, avg(price) from OrderEvent.win:time(30 sec)";
        EPStatement statement = cepServiceEngine.getEPAdministrator().createEPL(expression);

        /**
         * Subscribe EPL Statement Listener
         */
        MyListener listener = new MyListener();
        statement.addListener(listener);

        /**
         * Send sample Event for TEST
         */
        OrderEvent event = new OrderEvent("shirts", 1);
        cepServiceEngine.getEPRuntime().sendEvent(event);

        state = "ACTIVE";

        logger.info("[{}] CEP Engine Runner is started..................", cepEngineID);
    }

    public void stop() throws Exception {

        logger.info("[{}] CEP Engine Runner is starting..................", cepEngineID);

        if (cepServiceEngine != null && !cepServiceEngine.isDestroyed()) {
            cepServiceEngine.destroy();
            logger.debug("[{}] CEP Service Engine is destroyed successfully.", cepEngineID);
        }

        state = "STOPPED";

        logger.info("[{}] CEP Engine Runner is stopped..................", cepEngineID);
    }

    /**
     * Configure CEP Engine Option.
     * @return Configuration
     */
    private Configuration getEngineConfig() {

        Configuration engineConfig = new Configuration();

        engineConfig.addEventTypeAutoName("com.cloudine.bigdata.cep.service.event");

        return engineConfig;
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

    public long getEngineStartTime() {
        return engineStartTime;
    }

    public void setEngineStartTime(long engineStartTime) {
        this.engineStartTime = engineStartTime;
    }

    public long getCurrentEngineTime() {
        return currentEngineTime;
    }

    public void setCurrentEngineTime(long currentEngineTime) {
        this.currentEngineTime = currentEngineTime;
    }

    /**
     * Sample EPL Statement Listener ==> Output Adapter
     */
    public class MyListener implements UpdateListener {

        public void update(EventBean[] newEvents, EventBean[] oldEvents) {

            EventBean event = newEvents[0];
            System.out.println();
            System.out.println("itemName=" + event.get("itemName"));
            System.out.println("avg=" + event.get("avg(price)"));
            System.out.println("mymax=" + event.get("mymax"));
            System.out.println();
        }
    }

}
