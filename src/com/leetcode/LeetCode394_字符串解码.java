package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode394_字符串解码 {

    public String decodeString(String s) {

        LinkedList<Integer> multiStack = new LinkedList<>();
        LinkedList<String>  resStack = new LinkedList<>();
        int multi = 0;
        StringBuilder resBuilder = new StringBuilder();
        for(Character c: s.toCharArray()){
            if(c >='0' && c <= '9'){
                multi = multi * 10 + Integer.parseInt(c+"");
            }else if(c == '['){
                multiStack.add(multi);
                multi =0 ;
                resStack.add(resBuilder.toString());
                resBuilder = new StringBuilder();
            }else if(c==']'){
                int m = multiStack.removeLast();

                StringBuilder tmp = new StringBuilder();
                for(int i=0;i<m ;i++){
                    tmp.append(resBuilder);
                }

                resBuilder = new StringBuilder(resStack.removeLast()+tmp);

            }else{
                resBuilder.append(c);
            }
        }
        return resBuilder.toString();
    }
}
