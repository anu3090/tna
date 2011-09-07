package com.tedwon.esper.esperio.http;

import com.espertech.esperio.http.core.URIUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;

public class SupportHTTPClient {
    private static Log log = LogFactory.getLog(SupportHTTPClient.class);

    private HttpClient httpclient;

    public SupportHTTPClient() {
        httpclient = new DefaultHttpClient();
    }

    public void request(int port, String document, String... params) throws Exception {
        String uri = "http://localhost:" + port + "/" + document;
        URI requestURI = URIUtil.withQuery(new URI(uri), params);
        log.info("Requesting from URI " + requestURI);
        HttpGet httpget = new HttpGet(requestURI);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = null;
        try {
            responseBody = httpclient.execute(httpget, responseHandler);
        } catch (IOException e) {
            throw new RuntimeException("Error executing request:" + e.getMessage());
        }
    }

    public static void main(String args[]) throws Exception {
        SupportHTTPClient client = new SupportHTTPClient();
        client.request(8083, "sendevent", "stream", "SupportBean", "stringProp", "abc", "intProp", "5");
    }


}
