package com.cloudine.bigdata.cep.service.runtime;

import com.cloudine.bigdata.cep.service.adapter.AdapterManager;
import com.cloudine.bigdata.cep.service.engine.CEPEngineRunnerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * CEP Service Application Runtime Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPServiceApplicationRuntimeImpl implements CEPServiceApplicationRuntime {

    /**
     * SLF4J Logger.
     */
    private Logger logger = LoggerFactory.getLogger(CEPServiceApplicationRuntimeImpl.class);


    private CEPEngineRunnerImpl cepEngineRunner;

    private List<AdapterManager> outputAdapterList;

    private List<AdapterManager> inputAdapterList;

    @Override
    public void start() throws Exception {

        cepEngineRunner.start();

        for (AdapterManager outputAdapter : outputAdapterList) {
            outputAdapter.start();
        }

        for (AdapterManager inputAdapter : inputAdapterList) {
            inputAdapter.start();
        }
    }

    @Override
    public void stop() throws Exception {

        for (AdapterManager inputAdapter : inputAdapterList) {
            inputAdapter.stop();
        }

        for (AdapterManager outputAdapter : outputAdapterList) {
            outputAdapter.start();
        }

        cepEngineRunner.stop();
    }

    public CEPEngineRunnerImpl getCepEngineRunner() {
        return cepEngineRunner;
    }

    public void setCepEngineRunner(CEPEngineRunnerImpl cepEngineRunner) {
        this.cepEngineRunner = cepEngineRunner;
    }

    public List<AdapterManager> getOutputAdapterList() {
        return outputAdapterList;
    }

    public void setOutputAdapterList(List<AdapterManager> outputAdapterList) {
        this.outputAdapterList = outputAdapterList;
    }

    public List<AdapterManager> getInputAdapterList() {
        return inputAdapterList;
    }

    public void setInputAdapterList(List<AdapterManager> inputAdapterList) {
        this.inputAdapterList = inputAdapterList;
    }
}
