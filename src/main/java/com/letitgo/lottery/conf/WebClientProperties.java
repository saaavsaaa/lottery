package com.letitgo.lottery.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aaa on 2017/1/28.
 */
@Configuration
@ConfigurationProperties
public class WebClientProperties {

    @Value("${ticket.global.encoding}")
    private String encoding;

    @Value("${cookie.userId}")
    private String cookieUserId;

    @Value("${cookie.userToken}")
    private String cookieUserToken;

    @Value("${connection.maxTotal}")
    private int maxTotal;

    @Value("${connection.defaultMaxPerRoute}")
    private int defaultMaxPerRoute;

    public String getCookieUserId() {
        return cookieUserId;
    }

    public void setCookieUserId(String cookieUserId) {
        this.cookieUserId = cookieUserId;
    }

    public String getCookieUserToken() {
        return cookieUserToken;
    }

    public void setCookieUserToken(String cookieUserToken) {
        this.cookieUserToken = cookieUserToken;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
