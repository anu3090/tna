package com.tedwon.pilots.cep.client;

import com.tedwon.pilots.cep.utils.SupportHTTPClient;
import org.junit.Test;

public class ClientTest {

    @Test
    public void sendEvent() throws Exception {
        SupportHTTPClient client = new SupportHTTPClient();
        client.request(8083, "sendevent", "stream", "AccessLogEvent", "date", "mydate");

    }
}
