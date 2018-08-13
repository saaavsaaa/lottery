package com.letitgo.lottery.node;

import com.letitgo.lottery.node.node.doc.ElementNode;

/**
 * Created by aaa on 2017/1/30.
 */
public class Condition {
    private char[] attributeKye;
    private char[] operator;
    private char[] attributeValue;
    private int nodeLevel;
    //同层节点中的序号
    private int index;
    private ElementNode upLevel;
}
