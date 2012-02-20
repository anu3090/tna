package com.cloudine.bigdata.cep.service.adapter.output.csv;

/**
 * CSV Output Adapter Manager Interface.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public interface CSVOutputAdapterManagerMBean {

    void start() throws Exception;

    void stop() throws Exception;

    String getCepEngineID();

    void setCepEngineID(String cepEngineID);

    String getState();

    void setState(String state);

    String getStatementName();

    void setStatementName(String statementName);

    String getFieldNames();

    void setFieldNames(String fieldNames);
}
