package com.letitgo.lottery.node.node.type;

/**
 * Created by aaa on 2017/4/15.
 */
public class CharNode{
    final char current;

    CharNode(final char c){
        this.current = c;
    }
}

class CharTreeNode extends CharNode{
    final CharNode lNode;
    final CharNode rNode;

    CharTreeNode(final char c, final CharNode leftSubNode, final CharNode rightSubNode){
        super(c);
        this.lNode = leftSubNode;
        this.rNode = rightSubNode;
    }
}

// <editor-fold desc="char">
class SequentCharNode extends CharTreeNode{
    final String docType;

    SequentCharNode(char c, CharNode leftSubNode, CharNode rightSubNode, final String docType) {
        super(c, leftSubNode, rightSubNode);
        this.docType = docType;
    }
}

abstract class SequentUniqueCharsNode extends SequentCharNode{

    SequentUniqueCharsNode(char c, CharNode leftSubNode, CharNode rightSubNode, String docType) {
        super(c, leftSubNode, rightSubNode, docType);
    }

    //当后续多个字符唯一时，不需要在查找树节点了
    abstract char[] SequentChars();
}
// </editor-fold>
