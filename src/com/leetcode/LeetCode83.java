package com.leetcode;

import com.leetcode.LeetCode21_合并2个有序链表.ListNode;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/20
 */
public class LeetCode83 {


  public ListNode deleteDuplicates(ListNode head) {

    ListNode curr = head;
    while(curr != null && curr.next != null){
      if(curr.val == curr.next.val){
        curr.next = curr.next.next;
        continue;
      }else{
        curr = curr.next;
      }
    }
    return head;
  }
}
