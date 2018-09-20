package com.letitgo.lottery.util.analysis;

import com.letitgo.lottery.node.node.doc.DocNode;
import com.letitgo.lottery.node.node.doc.ElementNode;
import com.letitgo.lottery.util.Constant;

/**
 * Created by aaa on 18-8-13.
 */
public class NodeSelector {

    private String nodeType = "";
    private DocNode node;
    private char preChar;

    public boolean continueNextChar(final char currentChar) {
        // TODO: 2018/9/20 是否改为状态机
        if (currentChar == Constant.Node_Type_End
                && preChar == Constant.Escape) {
            return false;
        } else {
            nodeType += currentChar;
            node = new ElementNode();
            node.setNodeLevel(1);
            node.initializing(currentChar);
        }
        preChar = currentChar;
        return true;
    }

    public String getNodeType() {
        return nodeType;
    }

    public DocNode getNode() {
        return node;
    }
}
