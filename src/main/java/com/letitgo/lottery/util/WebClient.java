package com.letitgo.lottery.util;

import com.letitgo.lottery.center.PropertiesCenter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by aaa on 2017/1/28.
 */
@Component
public class WebClient {

    @Autowired
    private PropertiesCenter propertiesCenter;

    private volatile String cookieContent;
    private volatile String loginToken;
    private volatile String loginUserID;
    private volatile boolean cookieSeted = false;

    public String getHtml(String url) throws IOException {
        return buildHtml(get(url));
    }

    public InputStream get(String url) throws IOException {
        HttpResponse response = buildGetResponse(url);
        return extract(response);
    }

    public String post(String url, HttpEntity paras) throws IOException {
        HttpResponse response = buildPostResponse(url, paras);
        return buildHtml(extract(response));
    }

    public InputStream get(String url, String loginToken, String loginUserID) throws IOException {
        setCookieContent(loginToken, loginUserID);
        return get(url);
    }

    public String post(String url, String loginToken, String loginUserID, HttpEntity paras) throws IOException {
        setCookieContent(loginToken, loginUserID);
        return post(url, paras);
    }

    public void setCookieContent(String loginToken, String loginUserID){
        if (StringUtils.isEmpty(loginToken) || StringUtils.isEmpty(loginUserID)){
            cookieSeted = false;
            return;
        }
        this.loginToken = loginToken;
        this.loginUserID = loginUserID;
        // 创建一个本地上下文信息
        //HttpContext localContext = new BasicHttpContext();
        // 在本地上下问中绑定一个本地存储
        //localContext.setAttribute(HttpClientContext.COOKIE_STORE, cs);
        cookieSeted = true;
    }

    private String getCookieContent(){
        CookieStore cookieStore = new BasicCookieStore();
        cookieStore.addCookie(new BasicClientCookie(propertiesCenter.getWebClientProperties().getCookieUserToken(), loginToken));
        cookieStore.addCookie(new BasicClientCookie(propertiesCenter.getWebClientProperties().getCookieUserId(), loginUserID));
        List<Cookie> list = cookieStore.getCookies();
        cookieContent = "";
        for (Cookie cookie : list) {
            cookieContent += cookie.getName() + "=" + cookie.getValue() + ";";
        }
        return cookieContent;
    }

    private HttpClient buildHttpClient(){
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(propertiesCenter.getWebClientProperties().getMaxTotal());
        cm.setDefaultMaxPerRoute(propertiesCenter.getWebClientProperties().getDefaultMaxPerRoute());
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
        return httpclient;
    }

    private InputStream extract(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        return entity.getContent();
    }

    private String buildHtml(InputStream input) throws IOException {
        String line = null;
        StringBuilder txt = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, propertiesCenter.getWebClientProperties().getEncoding())
        );
        while ((line = reader.readLine()) != null) {
            txt.append(line);
        }
        reader.close();
        return txt.toString();
    }

    private HttpResponse buildGetResponse(String url) throws IOException {
        HttpGet httpget = new HttpGet(url);
        if (cookieSeted) {
            httpget.setHeader("Cookie", getCookieContent());
        }
        System.out.println("请求: " + httpget.getRequestLine());
        HttpClient httpClient = buildHttpClient();
        HttpResponse response = httpClient.execute(httpget);
        return response;
    }

    private HttpResponse buildPostResponse(String url, HttpEntity paras) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        if (cookieSeted) {
            httpPost.setHeader("Cookie", getCookieContent());
        }
        if (paras != null) {
            System.out.print(paras + "\n");
            httpPost.setEntity(paras);
        }
        System.out.println("请求: " + httpPost.getRequestLine());
        HttpClient httpClient = buildHttpClient();
        HttpResponse response = httpClient.execute(httpPost);
        return response;
    }

/*    private WebClient(){}

    public static WebClient get()
    {
        return Nested.instance;
    }

    //在第一次被引用时被加载
    static class Nested
    {
        private static WebClient instance = new WebClient();
    }*/
}
