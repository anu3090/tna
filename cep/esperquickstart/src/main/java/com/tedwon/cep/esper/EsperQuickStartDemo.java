package com.tedwon.cep.esper;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Esper Quick Start Demo Class.
 * <p/>
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 * <p/>See http://esper.codehaus.org/esperio-4.3.0/doc/reference/en/html/adapter_http.html
 * <p/>HTTP Request URI Sample: http://localhost:8079/sendevent?stream=MyFirewallEvent&name=Joe&changed=true
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class EsperQuickStartDemo {

    public void run() {

        /**
         * Configure CEP Engine Option
         */
        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.tedwon.cep.esper");

        /**
         * Create CEP Engine Instance
         */
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

        /**
         * Publish EPL Statement
         */
        String expression = "select Math.max(2, 3) as mymax, avg(price) from com.tedwon.cep.esper.EsperQuickStartDemo$OrderEvent.win:time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);

        /**
         * Subscribe EPL Statement Listener
         */
        MyListener listener = new MyListener();
        statement.addListener(listener);

        /**
         * Send sample Event for TEST
         */
        OrderEvent event = new OrderEvent("shirt", 74.50);
        epService.getEPRuntime().sendEvent(event);

        /**
         * Destory CEP Engine Instance
         */
        epService.destroy();
    }

    /**
     * Sample EPL Statement Listener ==> Output Adapter
     */
    public class MyListener implements UpdateListener {

        public void update(EventBean[] newEvents, EventBean[] oldEvents) {

            EventBean event = newEvents[0];
            System.out.println("avg=" + event.get("avg(price)"));
            System.out.println("mymax=" + event.get("mymax"));
        }
    }


    /**
     * Sample Order Event
     */
    public class OrderEvent {

        private String itemName;
        private double price;

        public OrderEvent(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
        }

        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }
    }


    public static void main(String[] args) {

        EsperQuickStartDemo startMainClass = new EsperQuickStartDemo();

        startMainClass.run();
    }
}
