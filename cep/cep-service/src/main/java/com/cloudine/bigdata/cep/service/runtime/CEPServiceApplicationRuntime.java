package com.cloudine.bigdata.cep.service.runtime;

import com.cloudine.bigdata.cep.service.adapter.AbstractAdapterManager;
import com.cloudine.bigdata.cep.service.engine.CEPEngineRunnerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * CEP Service Application Runtime Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class CEPServiceApplicationRuntime {

    /**
     * SLF4J Logger.
     */
    private Logger logger = LoggerFactory.getLogger(CEPServiceApplicationRuntime.class);


    private CEPEngineRunnerImpl cepEngineRunner;

    private Set<AbstractAdapterManager> outputAdapterSet;

    private Set<AbstractAdapterManager> inputAdapterSet;

    public void start() throws Exception {

        cepEngineRunner.start();

        System.out.println(outputAdapterSet);
        System.out.println(inputAdapterSet);

        for(AbstractAdapterManager outputAdapter : outputAdapterSet) {
            outputAdapter.start();
        }

        for(AbstractAdapterManager inputAdapter : inputAdapterSet) {
            inputAdapter.start();
        }
    }

    public void stop() throws Exception {

        for(AbstractAdapterManager inputAdapter : inputAdapterSet) {
            inputAdapter.stop();
        }

        for(AbstractAdapterManager outputAdapter : outputAdapterSet) {
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

    public Set<AbstractAdapterManager> getOutputAdapterSet() {
        return outputAdapterSet;
    }

    public void setOutputAdapterSet(Set<AbstractAdapterManager> outputAdapterSet) {
        this.outputAdapterSet = outputAdapterSet;
    }

    public Set<AbstractAdapterManager> getInputAdapterSet() {
        return inputAdapterSet;
    }

    public void setInputAdapterSet(Set<AbstractAdapterManager> inputAdapterSet) {
        this.inputAdapterSet = inputAdapterSet;
    }
}
