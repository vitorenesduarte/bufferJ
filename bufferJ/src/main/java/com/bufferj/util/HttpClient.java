package com.bufferj.util;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Vitor Enes <vitorenesduarte at gmail.com>
 */
public class HttpClient {

    private static final Logger logger = Logger.getLogger(HttpClient.class.getName());

    private static final HttpClient instance = new HttpClient();
    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final Charset encoding = Consts.UTF_8;

    public static HttpClient getInstance() {
        return instance;
    }

    public String get(URI uri) throws IOException {
        HttpGet httpGet = new HttpGet(uri);

        return execute(httpGet);
    }

    public String post(URI uri) throws IOException {
        HttpPost httpPost = new HttpPost(uri);

        return execute(httpPost);
    }

    public String post(URI uri, List<NameValuePair> formData) throws IOException {
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formData, encoding);
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(entity);

        return execute(httpPost);
    }

    private String execute(HttpRequestBase request) throws IOException {
        try (CloseableHttpResponse response = client.execute(request)) {

            StringWriter writer = new StringWriter();
            IOUtils.copy(response.getEntity().getContent(), writer, encoding.name());

            checkStatusCode(response.getStatusLine().getStatusCode());

            return writer.toString();
        }
    }

    private void checkStatusCode(int statusCode) {
        if (statusCode != 200) {
            logger.log(Level.WARNING, "Status code: {0}", statusCode);
        }
    }
}
