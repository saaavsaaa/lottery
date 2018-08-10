package com.letitgo.lottery.entity.node.doc;

import com.letitgo.lottery.util.Constant;

/**
 * Created by aaa on 2017/2/1.
 */
public class NodeNotes {
    /*
* e.g. : <!--...-->
* */
    // TODO: 2017/2/5 改为LinkedArray实现
    private char[] nonNode;
    private int nonNodeUsedLength;
    private char preChar;
    private boolean notesConfirmed = false;

    public static synchronized NodeNotes createNodeNotes(char c){
        //Ordinary people should not set the value which '!' to this "c" when they have no reason
        if (c != '!'){
            throw new IllegalArgumentException();
        }
        return new NodeNotes();
    }

    private NodeNotes(){
        nonNode = new char[Constant.Estimate_Notes_Length];
        nonNode[0] = '<';
        nonNode[1] = '!';
        this.nonNodeUsedLength = 2;
        preChar = '!';
    }

    /*
    * the result value is initial success or not
    * */
    public boolean initializing(char c){
        if (!notesConfirmed){
            return confirming(c);
        }
        if (nonNodeUsedLength == Constant.Estimate_Notes_Length - 1) {
            // TODO: 2017/2/1 放不下需要扩容
        }
        // TODO: 2017/2/1 结束逻辑
        if (c == '-'){}
        nonNode[nonNodeUsedLength] = c;
        return true;
    }

    protected boolean confirmedNotes(){
        return this.notesConfirmed;
    }

    private boolean confirming(char c){
        if (preChar == '!'){
            if(c == '-'){
                preChar = '-';
                nonNode[2] = '-';
                return true;
            } else {
                return false;
            }
        }
        if (preChar == '-'){
            if(c == '-'){
                preChar = '-';
                nonNode[3] = '-';
                this.nonNodeUsedLength++;
                return true;
            } else {
                return false;
            }
        }
        if (c != '-'){
            if (nonNode.length == 4 && nonNode[3] == '-'){
                this.notesConfirmed = true;
                return true;
            }
        }
        return false;
    }
}
