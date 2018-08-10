package com.letitgo.lottery;

import com.letitgo.lottery.util.PageContentOperation;
import com.letitgo.lottery.util.WebClient;
import java.io.IOException;
import java.io.InputStream;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by aaa on 18-8-10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    
    protected String prepareContent(final WebClient webClient) throws IOException {
        String url = "http://www.zhcw.com/ssq/";
        InputStream pageContent = webClient.get(url);
        return PageContentOperation.getContent(pageContent);
    }
}
