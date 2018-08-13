package com.letitgo.lottery.service.spider.impl;

import com.letitgo.lottery.center.PropertiesCenter;
import com.letitgo.lottery.node.node.doc.RootNode;
import com.letitgo.lottery.service.spider.SpiderService;
import com.letitgo.lottery.util.PageContentOperation;
import com.letitgo.lottery.util.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by aaa on 2017/1/28.
 */
@Service
public class DoubleColorBallSpiderServiceImpl implements SpiderService {

    @Autowired
    private PropertiesCenter propertiesCenter;

    @Autowired
    private WebClient webClient;

    public static void testExcuters(){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        service.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("ScheduledExecutorService:测试开始");

            }
        }, 5, 3, TimeUnit.SECONDS);
    }



    @Override
    public String test() throws Exception {
        String url = "https://www.microsoft.com/zh-cn"; //propertiesCenter.getTicketUrl();
//        String page = webClient.getHtml(propertiesCenter.getTicketUrl());

        // TODO: 2017/1/29  useStack or useHeap | Stream or reuse
        // TODO: 2017/1/29 非根节点可以用将解析后的表达式字符串或字符串数组的所有首字符开始匹配

        InputStream pageContent = webClient.get(url);
        InputStream beUseInput = PageContentOperation.clearDOCTYPENode(pageContent);
//        return PageContentOperation.getContent(beUseInput);

        RootNode rootNode = new RootNode();


        return ExistXPath(url);
    }

    private String ExistXPath(String url) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(url);
        System.out.println(doc.getChildNodes().getLength());
        XPathFactory xFactory = XPathFactory.newInstance();
        XPath xpath = xFactory.newXPath();
        XPathExpression expr = xpath.compile("*");//propertiesCenter.getDoubleColorBallSpiderProperties().getVersionPath()
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        System.out.println(nodes.getLength());
        return "";
    }

    @Override
    public void run() {

    }
}
