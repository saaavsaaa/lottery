package com.letitgo.lottery.util;

import com.letitgo.lottery.BaseTest;
import java.io.IOException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WebClientTest extends BaseTest {
    @Autowired
    private WebClient webClient;
    
    @Test
    public void testGet() throws IOException {
        String content = prepareContent(webClient);
        System.out.println(content);
    }
}
