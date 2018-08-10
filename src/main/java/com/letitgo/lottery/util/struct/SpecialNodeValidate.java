package com.letitgo.lottery.util.struct;

/**
 * Created by aaa on 2017/2/5.
 */
public interface SpecialNodeValidate {
    int getNextIndex(char c, int currentIndex);
    boolean startCheck(char c);
    boolean isChecked();
}
