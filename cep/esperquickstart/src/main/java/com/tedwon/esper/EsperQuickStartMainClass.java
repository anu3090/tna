package com.tedwon.esper;

import com.espertech.esper.client.*;

/**
 * Espert Quick Start Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author Ted Won
 * @version 1.0
 */
public class EsperQuickStartMainClass {

    public void run() {

        Configuration config = new Configuration();
        config.addEventTypeAutoName("com.tedwon.esper");
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
        String expression = "select Math.max(2, 3) as mymax, avg(price) from com.tedwon.esper.EsperQuickStartMainClass$OrderEvent.win:time(30 sec)";
        EPStatement statement = epService.getEPAdministrator().createEPL(expression);

        MyListener listener = new MyListener();
        statement.addListener(listener);

        OrderEvent event = new OrderEvent("shirt", 74.50);
        epService.getEPRuntime().sendEvent(event);
    }

    public static void main(String[] args) {
        EsperQuickStartMainClass test = new EsperQuickStartMainClass();
        test.run();
    }

    public class MyListener implements UpdateListener {
        public void update(EventBean[] newEvents, EventBean[] oldEvents) {
            EventBean event = newEvents[0];
            System.out.println("avg=" + event.get("avg(price)"));
            System.out.println("mymax=" + event.get("mymax"));
        }
    }


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

}
