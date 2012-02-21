package com.cloudine.bigdata.cep.service.runtime;

/**
 * CEP Service Application Runtime Interface.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public interface CEPServiceApplicationRuntime {

    public void start() throws Exception;

    public void stop() throws Exception;
}
