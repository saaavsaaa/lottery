package com.letitgo.lottery.node.node.doc;

import com.letitgo.lottery.util.Constant;
import com.letitgo.lottery.util.struct.SpecialNodeValidate;

import java.util.Stack;

/**
 * Created by aaa on 2017/2/1.
 */
public final class BodyNode extends ContainerNode implements SpecialNodeValidate {

    Stack<Character> cs = new Stack<>();

    private boolean checked = false;
    
    public BodyNode(){
        super.setNodeLevel(Constant.Root_Level + 1);
    }

    @Override
    public int getNextIndex(char c, int currentIndex) {
//        boolean isB = (c == 'b' || c == 'B') && this.standardUsedLength == 0;
//        boolean isO = (c == 'o' || c == 'O') && this.standardUsedLength == 1;
//        boolean isD = (c == 'd' || c == 'D') && this.standardUsedLength == 2;
//        boolean isY = (c == 'y' || c == 'Y') && this.standardUsedLength == 3;
        int nextIndex = -1;
        switch (c) {
            case 'b' :
            case 'B' : {
                if (currentIndex == 0) {
                    nextIndex = 1;
                }
            }
            case 'o' :
            case 'O' : {
                if (currentIndex == 1) {
                    nextIndex = 2;
                }
            }
            case 'd' :
            case 'D' : {
                if (currentIndex == 2) {
                    nextIndex = 3;
                }
            }
            case 'y' :
            case 'Y' : {
                if (currentIndex == 3) {
                    this.checked = true;
                    nextIndex = 4;
                }
            }
            default : {
                nextIndex = -1;
            }
        }
        return nextIndex;
    }

    @Override
    public boolean startCheck(char c) {
        return c == 'b' || c == 'B';
    }

    @Override
    public boolean isChecked() {
        return checked;
    }
}
