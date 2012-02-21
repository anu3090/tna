package com.cloudine.bigdata.cep.service.adapter;

import com.cloudine.bigdata.cep.service.adapter.input.csv.CSVInputAdapterManager;
import com.espertech.esper.client.EPServiceProvider;

/**
 * Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class AbstractAdapterManager implements CSVInputAdapterManager {

    protected String cepEngineID;

    protected EPServiceProvider cepServiceEngine;

    /**
     * Current State.
     * <p/>
     * STOPPED, ACTIVE
     */
    protected String state = "STOPPED";

    public String getCepEngineID() {
        return cepEngineID;
    }

    public void setCepEngineID(String cepEngineID) {
        this.cepEngineID = cepEngineID;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
