package com.tedwon.cep.http.input;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esperio.http.EsperIOHTTPAdapterPlugin;
import com.tedwon.cep.http.SupportHTTPClient;

import java.util.Properties;

/**
 * Esper Quick Start Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 * <p/>See http://esper.codehaus.org/esperio-4.3.0/doc/reference/en/html/adapter_http.html
 * <p/>HTTP Request URI Sample: http://localhost:8079/sendevent?stream=MyFirewallEvent&name=Joe&changed=true
 *
 * @author <a href=mailto:tedd824@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class EsperHttpInputAdapter {

    public void run() throws Exception {

        String port = "8083";
        boolean isNio = true;

        String esperIOHTTPConfig = "<esperio-http-configuration>\n" +
                "<service name=\"service1\" port=\"" + port + "\" nio=\"" + isNio + "\"/>" +
                "<get service=\"service1\" pattern=\"*\"/>" +
                "</esperio-http-configuration>";

        Configuration config = new Configuration();
        config.addPluginLoader("EsperIOHTTPAdapter", EsperIOHTTPAdapterPlugin.class.getName(), new Properties(), esperIOHTTPConfig);

        config.addEventTypeAutoName("com.tedwon.esper.event");
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select date from AccessLogEvent.win:time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);

        MyListener listener = new MyListener();
        statement.addListener(listener);


        SupportHTTPClient client = new SupportHTTPClient();
        client.request(8083, "sendevent", "stream", "AccessLogEvent", "date", "mydate");

        epService.destroy();

    }

    public class MyListener implements UpdateListener {
        public void update(EventBean[] newEvents, EventBean[] oldEvents) {
            EventBean event = newEvents[0];
            System.out.println("date=" + event.get("date"));
        }
    }

    public static void main(String[] args) throws Exception {
        EsperHttpInputAdapter test = new EsperHttpInputAdapter();
        test.run();
    }
}
