package com.letitgo.lottery.center;

import com.letitgo.lottery.conf.DoubleColorBallSpiderProperties;
import com.letitgo.lottery.conf.WebClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aaa on 2017/1/28.
 */
@Configuration
@EnableConfigurationProperties({DoubleColorBallSpiderProperties.class, WebClientProperties.class})
public class PropertiesCenter {

    @Autowired
    private DoubleColorBallSpiderProperties doubleColorBallSpiderProperties;

    @Autowired
    private WebClientProperties webClientProperties;

    public DoubleColorBallSpiderProperties getDoubleColorBallSpiderProperties(){
        return doubleColorBallSpiderProperties;
    }

    public WebClientProperties getWebClientProperties(){
        return webClientProperties;
    }

    public String getTicketUrl(){
        return doubleColorBallSpiderProperties.getBaseUrl();
    }
}
