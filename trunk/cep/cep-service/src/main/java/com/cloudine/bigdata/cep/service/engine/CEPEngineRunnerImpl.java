package com.cloudine.bigdata.cep.service.engine;

import com.cloudine.bigdata.cep.service.event.OrderEvent;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.client.deploy.DeploymentResult;
import com.espertech.esper.client.deploy.EPDeploymentAdmin;
import com.espertech.esper.client.deploy.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * CEP Engine Runner Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPEngineRunnerImpl implements CEPEngineRunner {

    /**
     * SLF4J Logger.
     */
    private Logger logger = LoggerFactory.getLogger(CEPEngineRunnerImpl.class);

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

    /**
     * CEP Engine reference.
     */
    private EPServiceProvider cepServiceEngine;

    /**
     * Custom Esper Runtime Implementation.
     */
    private CEPEPRuntimeImpl runtimeImpl;


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

        // Obtain Runtime Object
        runtimeImpl = (CEPEPRuntimeImpl) cepServiceEngine.getEPRuntime();

        // Deploy EPL statements
        deployEPLStatements();

        cepServiceEngine.getEPAdministrator().startAllStatements();

        EPStatement statement = cepServiceEngine.getEPAdministrator().getStatement("SampleEPL");

        /**
         * Subscribe EPL Statement Listener
         */
//        MyListener listener = new MyListener();
//        statement.addListener(listener);

        /**
         * Send sample Event for TEST
         */
        OrderEvent event = new OrderEvent("shirts", 1);
        cepServiceEngine.getEPRuntime().sendEvent(event);


        state = "ACTIVE";

        logger.info("[{}] CEP Engine Runner is started successfully.", cepEngineID);
    }

    public void stop() throws Exception {

        logger.info("[{}] CEP Engine Runner is stopping..................", cepEngineID);

        if (cepServiceEngine != null && !cepServiceEngine.isDestroyed()) {
            cepServiceEngine.destroy();
            logger.debug("[{}] CEP Service Engine is destroyed successfully.", cepEngineID);
        }

        state = "STOPPED";

        logger.info("[{}] CEP Engine Runner is stopped successfully.", cepEngineID);
    }

    /**
     * Configure CEP Engine Option.
     *
     * @return Configuration
     */
    private Configuration getEngineConfig() {

        Configuration engineConfig = new Configuration();

        // Custom Runtime Implementation
        engineConfig.getEngineDefaults().getAlternativeContext().setRuntime("com.cloudine.bigdata.cep.service.engine.CEPEPRuntimeImpl");
        engineConfig.getEngineDefaults().getAlternativeContext().setAdmin("com.cloudine.bigdata.cep.service.engine.CEPEPAdministratorImpl");

        engineConfig.addEventTypeAutoName("com.cloudine.bigdata.cep.service.event");

        return engineConfig;
    }

    /**
     * Deploy EPL statements.
     *
     * <p/>http://esper.codehaus.org/esper-4.5.0/doc/reference/en/html/epl_clauses.html#epl_createschema
     */
    private void deployEPLStatements() throws Exception {

        EPDeploymentAdmin deploymentAdmin = cepServiceEngine.getEPAdministrator().getDeploymentAdmin();
        Module module = deploymentAdmin.read("conf/statements.epl");
        DeploymentResult deploymentResult = deploymentAdmin.deploy(module, null);
        logger.info("[{}] Statements Deployment ID: {}", new Object[]{cepEngineID, deploymentResult});
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
