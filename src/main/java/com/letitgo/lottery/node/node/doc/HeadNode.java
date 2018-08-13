package com.letitgo.lottery.node.node.doc;

import com.letitgo.lottery.util.Constant;
import com.letitgo.lottery.util.struct.SpecialNodeValidate;

/**
 * Created by aaa on 2017/2/1.
 */
public final class HeadNode extends ContainerNode implements SpecialNodeValidate {
    private boolean checked = false;

    public HeadNode(){
        super.setNodeLevel(Constant.Root_Level + 1);
    }

    public boolean startCheck(char c){
        return c == 'h' || c == 'H';
    }

    /*
    * if contain c return index of next char, if not return -1
    * */
    public int getNextIndex(char c, int currentIndex){
//        boolean isH = (c == 'h' || c == 'H') && index == 0;
//        boolean isE = (c == 'e' || c == 'E') && index == 1;
//        boolean isA = (c == 'a' || c == 'A') && index == 2;
//        boolean isD = (c == 'd' || c == 'D') && index == 3;
        int nextIndex = -1;
        switch (c) {
            case 'H' :
            case 'h' : {
                if (currentIndex == 0) {
                    nextIndex = 1;
                }
            }
            case 'E' :
            case 'e' : {
                if (currentIndex == 1) {
                    nextIndex = 2;
                }
            }
            case 'A' :
            case 'a' : {
                if (currentIndex == 2) {
                    nextIndex = 3;
                }
            }
            case 'D' :
            case 'd' : {
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

    public boolean isChecked() {
        return checked;
    }
}
