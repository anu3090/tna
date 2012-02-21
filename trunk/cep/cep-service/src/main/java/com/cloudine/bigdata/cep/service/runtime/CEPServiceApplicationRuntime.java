package com.cloudine.bigdata.cep.service.runtime;

import com.cloudine.bigdata.cep.service.adapter.AbstractAdapterManagerImpl;
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

    private Set<AbstractAdapterManagerImpl> outputAdapterSet;

    private Set<AbstractAdapterManagerImpl> inputAdapterSet;

    public void start() throws Exception {

        cepEngineRunner.start();

        System.out.println(outputAdapterSet);
        System.out.println(inputAdapterSet);

        for(AbstractAdapterManagerImpl outputAdapter : outputAdapterSet) {
            outputAdapter.start();
        }

        for(AbstractAdapterManagerImpl inputAdapter : inputAdapterSet) {
            inputAdapter.start();
        }
    }

    public void stop() throws Exception {

        for(AbstractAdapterManagerImpl inputAdapter : inputAdapterSet) {
            inputAdapter.stop();
        }

        for(AbstractAdapterManagerImpl outputAdapter : outputAdapterSet) {
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

    public Set<AbstractAdapterManagerImpl> getOutputAdapterSet() {
        return outputAdapterSet;
    }

    public void setOutputAdapterSet(Set<AbstractAdapterManagerImpl> outputAdapterSet) {
        this.outputAdapterSet = outputAdapterSet;
    }

    public Set<AbstractAdapterManagerImpl> getInputAdapterSet() {
        return inputAdapterSet;
    }

    public void setInputAdapterSet(Set<AbstractAdapterManagerImpl> inputAdapterSet) {
        this.inputAdapterSet = inputAdapterSet;
    }
}
