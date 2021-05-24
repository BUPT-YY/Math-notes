/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public static ListNode deleteDuplicates(ListNode head) {
    // baseCase
    if (head == null || head.next == null) {
      return head;
    }

    ListNode next = head.next;
    // 如果是这种情况
    //      1 --> 1 --> 1 --> 2 --> 3
    //     head  next
    // 1.则需要移动next直到出现与当前head.value不相等的情况（含null）
    // 2.并且此时的head已经不能要了，因为已经head是重复的节点
    // --------------else-------------
    //      1 --> 2 --> 3
    //     head  next
    // 3.如果没有出现1的情况，则递归返回的节点就作为head的子节点
    if (head.val == next.val) {
      // 1
      while (next != null && head.val == next.val) {
        next = next.next;
      }
      // 2
      head = deleteDuplicates(next);
    } else {
      // 3
      head.next = deleteDuplicates(next);
    }
    return head;
  }
}
