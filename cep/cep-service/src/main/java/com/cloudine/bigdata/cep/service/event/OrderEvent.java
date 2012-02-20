package com.cloudine.bigdata.cep.service.event;

/**
 * Order Event Type Class.
 * <p/>See http://esper.codehaus.org/tutorials/tutorial/quickstart.html
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class OrderEvent {

    private String itemName;

    private double price;

    public OrderEvent() {
    }

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

    @Override
    public String toString() {
        return "OrderEvent{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
