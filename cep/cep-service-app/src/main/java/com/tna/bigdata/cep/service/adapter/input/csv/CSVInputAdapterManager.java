package com.tna.cep.service.adapter.input.csv;

/**
 * Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public interface CSVInputAdapterManager {

    public void start() throws Exception;

    public void stop() throws Exception;

    public String getState();

}
