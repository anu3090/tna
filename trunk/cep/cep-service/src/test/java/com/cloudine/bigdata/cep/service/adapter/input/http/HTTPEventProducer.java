package com.cloudine.bigdata.cep.service.adapter.input.http;

import org.junit.Test;

/**
 * HTTP Event Producer Class.
 *
 * @author <a href=mailto:iamtedwon@gmail.com">Ted Won</a>
 * @version 1.0
 */
public class HTTPEventProducer {

    @Test
    public void generate() throws Exception {

        SupportHTTPClient client = new SupportHTTPClient();
        client.request(8087, "sendevent", "stream", "OrderEvent", "itemName", "myitemName", "price", "1");

    }
}
