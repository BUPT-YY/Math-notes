/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode first = head, second = head.next, tail = swapPairs(head.next.next);
    first.next = tail;
    second.next = first;
    return second;
  }
}
