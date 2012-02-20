package com.cloudine.bigdata.cep.service.engine;

/**
 * Created by IntelliJ IDEA.
 * User: ted
 * Date: 2/20/12
 * Time: 1:24 오후
 * To change this template use File | Settings | File Templates.
 */
public interface CEPEngineRunnerMBean {

    void start() throws Exception;

    void stop() throws Exception;

}
