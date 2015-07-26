package com.bufferj.util;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class HttpClient {

    private static final HttpClient instance = new HttpClient();
    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final String encoding = "UTF-8";

    public static HttpClient getInstance() {
        return instance;
    }

    public String get(URI uri) throws IOException {
        System.out.println(uri.toString());
        
        HttpGet httpGet = new HttpGet(uri);

        try (CloseableHttpResponse response = client.execute(httpGet)) {
            
            StringWriter writer = new StringWriter();
            IOUtils.copy(response.getEntity().getContent(), writer, encoding);

            System.out.println("HC: " + writer.toString());
            return writer.toString();
        }
    }
}
