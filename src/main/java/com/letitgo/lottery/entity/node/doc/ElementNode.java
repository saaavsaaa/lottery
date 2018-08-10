package com.letitgo.lottery.entity.node.doc;

import com.letitgo.lottery.util.Constant;

import java.util.List;

/**
 * Created by aaa on 2017/1/30.
 */
public class ElementNode extends DocNode {
    private ElementNode upLevelNode;
    //同层节点中的序号
    private int index;
    private ElementNode currentNode;


    private boolean canEmbedChild;

    //考虑是否保留
    private List<ElementNode> children;

    private static synchronized ElementNode createNode(){
        return new ElementNode();
    }

    private ElementNode(){
        this(Constant.Root_Level + 2);
    }

    private ElementNode(int nodeLevel){
        super.setNodeLevel(nodeLevel);
    }

    @Override
    public void initElementType(char c) {
        super.initElementType(c);
    }

    public void initAttributes(char c) {
        //判断key operator value
    }
}
