package com.letitgo.lottery.util.analysis;

import com.letitgo.lottery.node.node.doc.DocNode;

/**
 * Created by aaa on 18-8-13.
 */
public class NodeSelector {

    private String nodeType;
    private DocNode node;

    public boolean continueNextChar(final char currentChar) {
        
        return true;
    }

    public String getNodeType() {
        return nodeType;
    }

    public DocNode getNode() {
        return node;
    }
}
