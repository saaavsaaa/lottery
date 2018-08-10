package com.letitgo.lottery.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by aaa on 2017/1/28.
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:spider.properties")
public class DoubleColorBallSpiderProperties {

    @Value("${doubleColor.page.url}")
    private String baseUrl;

    @Value("${doubleColor.version.xpath}")
    private String versionPath;

    @Value("${doubleColor.winning.xpath}")
    private String winningPath;

    @Value("${doubleColor.blue.DOMKey}")
    private String blueDOMKey = "class";

    @Value("${doubleColor.blue.DOMValue}")
    private String blueDOMValue = "blue";

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getVersionPath() {
        return versionPath;
    }

    public void setVersionPath(String versionPath) {
        this.versionPath = versionPath;
    }

    public String getWinningPath() {
        return winningPath;
    }

    public void setWinningPath(String winningPath) {
        this.winningPath = winningPath;
    }

    public String getBlueDOMKey() {
        return blueDOMKey;
    }

    public void setBlueDOMKey(String blueDOMKey) {
        this.blueDOMKey = blueDOMKey;
    }

    public String getBlueDOMValue() {
        return blueDOMValue;
    }

    public void setBlueDOMValue(String blueDOMValue) {
        this.blueDOMValue = blueDOMValue;
    }
}
