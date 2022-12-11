package com.leetcode.jianzhi;

import com.google.common.collect.Lists;
import com.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class jianzhi06_从尾到头打印链表 {

    List<Integer> list = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;

    }

    public void reverse(ListNode head){
        if(head ==null){
            return ;
        }
        reverse(head.next);
        list.add(head.val);
    }


}
