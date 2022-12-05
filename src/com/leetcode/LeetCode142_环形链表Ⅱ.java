package com.leetcode;

import com.leetcode.LeetCode21_合并2个有序链表.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :yest
 * @copyright: taofen8
 * @date: 2020/7/23
 * 获取环形链表 切入点
 */
public class LeetCode142_环形链表Ⅱ {

  public ListNode detectCycle(ListNode head) {
    if(head == null){
      return null;
    }
    Set<ListNode> set = new HashSet<ListNode>();
    while(head != null){
      if(set.contains(head)) {
        return head;
      }
      set.add(head);
      head = head.next;
    }
    return null;
  }


  public class Solution {
    private ListNode getIntersect(ListNode head) {
      ListNode tortoise = head;
      ListNode hare = head;

      while (hare != null && hare.next != null) {
        tortoise = tortoise.next;
        hare = hare.next.next;
        if (tortoise == hare) {
          return tortoise;
        }
      }

      return null;
    }

    public ListNode detectCycle(ListNode head) {
      if (head == null) {
        return null;
      }

      ListNode intersect = getIntersect(head);
      if (intersect == null) {
        return null;
      }

      ListNode ptr1 = head;
      ListNode ptr2 = intersect;
      while (ptr1 != ptr2) {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
      }

      return ptr1;
    }
  }

}
