/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    else if (head.next == null) return new TreeNode(head.val);
    ListNode pre = head;
    ListNode p = pre.next;
    ListNode q = p.next;
    // 找到链表的中点p
    while (q != null && q.next != null) {
      pre = pre.next;
      p = pre.next;
      q = q.next.next;
    }
    // 将中点左边的链表分开
    pre.next = null;
    TreeNode root = new TreeNode(p.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(p.next);
    return root;
  }
}
