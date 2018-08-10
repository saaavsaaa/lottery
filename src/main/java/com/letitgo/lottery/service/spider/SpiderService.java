package com.letitgo.lottery.service.spider;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by aaa on 2017/1/28.
 */
public interface SpiderService {
    String test() throws Exception;

    void run();
}
