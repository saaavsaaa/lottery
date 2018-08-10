package com.letitgo.lottery.util.struct;

import com.letitgo.lottery.util.Constant;

import javax.management.ObjectName;
import java.util.Arrays;

/**
 * Created by aaa on 2017/2/5.
 */
public class OnlyAddArray {
    private char[] array;
    private int usedLength = 0;

    public OnlyAddArray(){
        this(Constant.Array_Initial_Length);
    }

    public OnlyAddArray(int initialCapacity){
        this.array = new char[initialCapacity];
    }

    public OnlyAddArray(char[] array){
//        this.array = Arrays.copyOf(array, array.length);
        this(array.length);
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public void add(char c) {
//        if (c == ' '){ throw new IllegalArgumentException(); }
        this.array[this.usedLength] = c;
        this.usedLength++;
    }

    public char[] getArray(){
        return this.array;
    }

    public boolean equals(char[] other){
        int otherLength = other.length;
        if (this.usedLength != otherLength){
            return false;
        }
        while (otherLength > 0){
            if (this.array[otherLength] == other[otherLength]){
                otherLength--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
