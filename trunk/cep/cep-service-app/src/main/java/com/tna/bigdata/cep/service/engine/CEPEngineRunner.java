package com.tna.cep.service.engine;

/**
 * CEP Engine Runner Interface.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public interface CEPEngineRunner {

    void start() throws Exception;

    void stop() throws Exception;

}
