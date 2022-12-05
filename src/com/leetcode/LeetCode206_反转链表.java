package com.leetcode;

public class LeetCode206_反转链表 {

    public LeetCode21_合并2个有序链表.ListNode reverseList(LeetCode21_合并2个有序链表.ListNode head) {
        LeetCode21_合并2个有序链表.ListNode pre = null;
        LeetCode21_合并2个有序链表.ListNode cur = head;

        while(cur != null){
            LeetCode21_合并2个有序链表.ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;

        }

        return  pre;
    }


}
