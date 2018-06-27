package cn.edu.zzti.zut.qli.utils;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Sender {

    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30 * 1000)
            .setSocketTimeout(30 * 1000)
            .build();

    private static final HttpClient httpClient = HttpClients.createDefault();

    public static String send(HttpRequestBase httpRequest) throws Exception {
        httpRequest.setConfig(requestConfig);

        HttpResponse result = httpClient.execute(httpRequest);
        String response = EntityUtils.toString(result.getEntity());
        return response;
    }

    public static HttpGet buildGetRequest(String url) {
        return new HttpGet(url);
    }

    public static HttpGet buildGetRequest(String url, String request) {
        if (null == request || 0 == request.length()) return new HttpGet(url);
        return new HttpGet(url + "?" + new String(request));
    }

    public static HttpPost buildPostRequest(String url, String request) throws Exception {
        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(request));
        return post;
    }

    public static HttpPost buildPostRequest(String url, Map<String, String> model) throws Exception {
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        for (Map.Entry<String, String> e : model.entrySet()) {
            list.add(new BasicNameValuePair(e.getKey(), e.getValue()));
        }
        post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        return post;
    }
}
