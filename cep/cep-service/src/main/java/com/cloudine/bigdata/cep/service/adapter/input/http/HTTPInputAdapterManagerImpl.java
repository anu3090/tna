package com.cloudine.bigdata.cep.service.adapter.input.http;

import com.cloudine.bigdata.cep.service.adapter.AbstractAdapterManagerImpl;
import com.espertech.esperio.http.EsperIOHTTPAdapter;
import com.espertech.esperio.http.config.ConfigurationHTTPAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class HTTPInputAdapterManagerImpl extends AbstractAdapterManagerImpl {

    /**
     * SLF4J Logging
     */
    private Logger logger = LoggerFactory.getLogger(HTTPInputAdapterManagerImpl.class);

    private EsperIOHTTPAdapter iohttpAdapter;

    private ConfigurationHTTPAdapter adapterConfig;

    private String port;

    @Override
    public void start() throws Exception {

        logger.info("[{}] HTTP Input Adapter Starting..................", cepEngineID);

        adapterConfig = new ConfigurationHTTPAdapter();

        try {

            this.configure(adapterConfig, port);

            iohttpAdapter = new EsperIOHTTPAdapter(adapterConfig, cepEngineID);
            iohttpAdapter.start();

        } catch (Exception e) {

            String message = "[" + cepEngineID + "] HTTP Input Adapter Failed to start: ";
            logger.error(message, e);
            logger.error("port= {}", port);
            throw new Exception(message, e);
        }

        state = "ACTIVE";

        logger.info("[{}] HTTP Input Adapter Started successfully.", cepEngineID);
    }

    @Override
    public void stop() throws Exception {

        logger.info("[{}] HTTP Input Adapter Stopping..................", cepEngineID);

        if (iohttpAdapter != null) {

            new Thread(new Runnable() {

                public void run() {

                    iohttpAdapter.destroy();
                    iohttpAdapter = null;
                    adapterConfig = null;
                }
            }).start();
        }

        state = "STOPPED";

        logger.info("[{}] HTTP Input Adapter Stopped successfully", cepEngineID);
    }

    public void configure(ConfigurationHTTPAdapter adapterConfig, String port) {

        String xml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "<esperio-http-configuration xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'\n" +
                "                            xmlns='http://www.espertech.com/schema/esperio-http'\n" +
                "                            xsi:noNamespaceSchemaLocation='esperio-http-configuration-4-0.xsd'>\n" +
                "\t<service name='cepHTTPService' port='" + port + "' nio='true'/>\n" +
                "\t<get service='cepHTTPService' pattern='*'/>\n" +
                "</esperio-http-configuration>";

        logger.debug("HTTP Input Adapter Configuration: {}", xml);

        adapterConfig.configureFromString(xml);
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
