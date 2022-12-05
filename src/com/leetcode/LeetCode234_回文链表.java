package com.leetcode;

import com.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode234_回文链表 {

    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }


        int l = 0;int r = list.size()-1;

        while(l<r){
            if(list.get(l) !=list.get(r)){
                return  false;
            }

            l++;
            r--;
        }
        return true;
    }

}
