package com.letitgo.lottery.entity.node.type;

/**
 * Created by aaa on 2017/4/15.
 * 字符树，大小写int差，查树建实例，实例节点的最后一个上层节点应该是空格字符
 * 首字母不存在则直接创建OtherElementNode，存在则查找SequentCharTree
 * a b c d e f h i k l m n o p q r s t u v w
 * 此处不是按字符二分，而是按常用标签首字母
 */
public final class FirstCharTree {

    private static final CharNode root = new CharTreeNode('l', FirstCharTree.createLeftSubTree(), FirstCharTree.createRightSubTree());

    private FirstCharTree(){}

    private CharNode getNode(final char c){
        if ('!' == c){

        }
        return null;
    }

    private static CharNode createLeftSubTree(){
        CharNode a = FirstCharTree.createLeafCharNode('a');
        CharNode d = FirstCharTree.createLeafCharNode('d');
        CharNode c = new CharTreeNode('c', FirstCharTree.createSpaceCharNode(), d);
        CharNode b = new CharTreeNode('b', a, c);

        CharNode f = FirstCharTree.createLeafCharNode('f');
        CharNode k = FirstCharTree.createLeafCharNode('k');
        CharNode h = new CharTreeNode('h', f, FirstCharTree.createSpaceCharNode());
        CharNode i = new CharTreeNode('i', h, k);

        return new CharTreeNode('e', b , i);
    }

    private static CharNode createRightSubTree(){
        CharNode m = FirstCharTree.createLeafCharNode('m');
        CharNode q = FirstCharTree.createLeafCharNode('q');
        CharNode n = new CharTreeNode('n', m, FirstCharTree.createSpaceCharNode());
        CharNode p = new CharTreeNode('p', FirstCharTree.createSpaceCharNode(), q);
        CharNode b = new CharTreeNode('b', n, p);

        CharNode s = FirstCharTree.createLeafCharNode('s');
        CharNode w = FirstCharTree.createLeafCharNode('w');
        CharNode t = new CharTreeNode('t', s, FirstCharTree.createSpaceCharNode());
        CharNode v = new CharTreeNode('v', FirstCharTree.createSpaceCharNode(), w);
        CharNode i = new CharTreeNode('i', t, v);

        return new CharTreeNode('r', b , i);
    }

    private static char lowToHigh(char low){
        return (char)(low - 32);
    }

    /*
    * 空格字符是32，所以节点在左子节点上
    * */
    private static CharNode createLeafCharNode(final char leafNode){
        return new CharTreeNode(leafNode, FirstCharTree.createSpaceCharNode(), null);
    }

    private static CharNode createSpaceCharNode(){
        //空格后SequentCharTree统一挂左节点
        return new CharTreeNode(' ', new CharTreeNode(' ', /*todo ： SequentCharNode*/null, null), null);
    }
}
