package com.letitgo.lottery.util.analysis;

import com.letitgo.lottery.BaseTest;
import com.letitgo.lottery.util.WebClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by aaa on 18-8-10.
 */
public class NodeResolveTest extends BaseTest {
    @Autowired
    private WebClient webClient;

    @Test
    public void nextTest() throws IOException {
        NodeResolve resolve = new NodeResolve(prepareContent(webClient));
        resolve.next();
        System.out.println(resolve.getCurrent());
    }
}
