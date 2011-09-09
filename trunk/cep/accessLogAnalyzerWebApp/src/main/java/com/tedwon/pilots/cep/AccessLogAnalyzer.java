package com.tedwon.pilots.cep;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esperio.http.EsperIOHTTPAdapterPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Access Log Analyzer Class.
 * <p/>
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 * <p/>See http://esper.codehaus.org/esperio-4.3.0/doc/reference/en/html/adapter_http.html
 * <p/>HTTP Request URI Sample: http://localhost:8079/sendevent?stream=MyFirewallEvent&name=Joe&changed=true
 *
 * @author <a href=mailto:tedd824@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class AccessLogAnalyzer {

    private final Logger logger = LoggerFactory.getLogger(AccessLogAnalyzer.class);

    private final String providerURI = "AccessLogAnalyzerEngine";
    private EPServiceProvider epService;
    private EPStatement statement;
    private String port = "8083";
    private boolean isNio = true;


    public void start() throws Exception {

        logger.trace("call start()");


        Configuration config = new Configuration();

        // Set up HTTP Input Adapter
        String esperIOHTTPConfig = "<esperio-http-configuration>\n" +
                "<service name=\"service1\" port=\"" + port + "\" nio=\"" + isNio + "\"/>" +
                "<get service=\"service1\" pattern=\"*\"/>" +
                "</esperio-http-configuration>";
        config.addPluginLoader("EsperIOHTTPAdapter", EsperIOHTTPAdapterPlugin.class.getName(), new Properties(), esperIOHTTPConfig);

        // Set up Event
        config.addEventTypeAutoName("com.tedwon.pilots.cep.event");

        // Initiate CEP Engine
        epService = EPServiceProviderManager.getProvider(providerURI, config);

        // Register EPL
        String expression = "select date from AccessLogEvent.win:time(30 sec)";
        statement = epService.getEPAdministrator().createEPL(expression);

        // Register Process Result Listener
        MyListener listener = new MyListener();
        statement.addListener(listener);

    }

    public void process() throws Exception {

        logger.trace("call process()");


    }


    public void stop() throws Exception {

        logger.trace("call stop()");


        try {
            statement.destroy();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            epService.destroy();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public class MyListener implements UpdateListener {

        public void update(EventBean[] newEvents, EventBean[] oldEvents) {

            logger.trace("call MyListener.update()");

            EventBean event = newEvents[0];
            System.out.println("date=" + event.get("date"));
        }
    }

    public static void main(String[] args) throws Exception {

        AccessLogAnalyzer test = new AccessLogAnalyzer();
        test.start();
        test.process();
        test.stop();
    }
}

