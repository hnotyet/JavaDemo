package com.leetcode.jianzhi;

import java.util.Stack;

public class jianzhi09 {

    class CQueue {
        private Stack<Integer> s1 = null; //正序的
        private Stack<Integer> s2 = null; //倒序的

        public CQueue() {
            s1 = new Stack();
            s2 = new Stack();
        }

        public void appendTail(int value) {
            if(s1.isEmpty()){
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
            s1.push(value);
        }

        public int deleteHead() {
            if(s2.isEmpty()){
                if(s1.isEmpty()){
                    return -1;
                }

                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }

}
