package com.letitgo.lottery.util.struct;

/**
 * Created by aaa on 2017/2/5.
 */
public class Validating {

    // TODO: 2017/3/11 栈 括号匹配 

    private boolean started = false;
    private boolean checkEnd = false;
    private int currentIndex = -1;
    
    private SpecialNodeValidate waitCheckNode = null;

    public Validating(SpecialNodeValidate node){
        if (node == null){
            throw new IllegalArgumentException();
        }
        this.waitCheckNode = node;
    }

    public void checkNode(char c){
        if (this.started){
            this.currentIndex = this.waitCheckNode.getNextIndex(c, this.currentIndex);
            if (this.currentIndex > -1){
                if (this.waitCheckNode.isChecked()){
                    this.checkEnd = true;
                }
            } else {
                this.waitCheckNode = null;
                this.checkEnd = true;
                this.currentIndex = -1;
            }
        } else {
            this.started = this.waitCheckNode.startCheck(c);
            if (this.started) {
                this.currentIndex = 0;
            }
        }
    }

    public SpecialNodeValidate getNode(){
        if (this.checkEnd){
            return this.waitCheckNode;
        }
        throw new IllegalMonitorStateException();
    }

    /*
    * check end return build success node or null
    * */
    public boolean checkEnd(char c) {
        this.checkNode(c);
        return this.checkEnd;
    }
}
