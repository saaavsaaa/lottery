package com.letitgo.lottery.entity.node.doc;

import java.util.List;

/**
 * Created by aaa on 2017/2/5.
 */
public abstract class ContainerNode extends DocNode {
    /*
    * current operating child node
    * */
    protected DocNode currentNode;
    protected List<DocNode> children;
}
