/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    if (lists.length == 1) return lists[0];

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (ListNode list : lists) {
      ListNode temp = list;
      while (temp != null) {
        pq.add(Integer.valueOf(temp.val));
        temp = temp.next;
      }
    }

    ListNode result = new ListNode(0);
    ListNode curr = result;
    while (!pq.isEmpty()) {
      ListNode nextNode = new ListNode(pq.remove().intValue());
      curr.next = nextNode;
      curr = curr.next;
    }
    return result.next;
  }
}
