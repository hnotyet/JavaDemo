package com.leetcode;


import com.leetcode.model.ListNode;

public class LeetCode23_合并K个升序链表 {

  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0){
      return null;
    }

    if(lists.length == 1){
      return lists[0];
    }

    ListNode left = lists[0];
    for( int i = 1;i<lists.length;i++){
      left = mergeTwoLists(left,lists[i]);
    }

    return left;

  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    if(l1 == null){
      return l2;
    } else if(l2 == null) {
      return l1;
    }else if(l1.val < l2.val){
      l1.next = mergeTwoLists(l1.next,l2);
      return l1;
    }else{
      l2.next = mergeTwoLists(l1,l2.next);
      return l2;
    }

  }

}
