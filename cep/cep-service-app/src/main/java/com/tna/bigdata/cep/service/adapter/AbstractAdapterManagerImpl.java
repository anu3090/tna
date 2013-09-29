package com.tna.cep.service.adapter;

import com.espertech.esper.client.EPServiceProvider;

/**
 * Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public abstract class AbstractAdapterManagerImpl implements AdapterManager {

    /**
     * CEP Engine ID.
     */
    protected String cepEngineID;

    /**
     * Current State.
     * <p/>
     * STOPPED, ACTIVE
     */
    protected EPServiceProvider cepServiceEngine;

    /**
     * Current State.
     * <p/>
     * STOPPED, ACTIVE
     */
    protected String state = "STOPPED";

    public abstract void start() throws Exception;

    public abstract void stop() throws Exception;

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
}
