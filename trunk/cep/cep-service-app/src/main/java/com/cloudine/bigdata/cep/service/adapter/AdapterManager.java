package com.cloudine.bigdata.cep.service.adapter;

/**
 * Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public interface AdapterManager {

    public void start() throws Exception;

    public void stop() throws Exception;

    public String getState();

}
