/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  private int pre = 0, in = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return recursive(preorder, inorder, Integer.MAX_VALUE);
  }

  public TreeNode recursive(int[] preorder, int[] inorder, int stop) {
    if (pre >= preorder.length) return null;
    if (inorder[in] == stop) {
      in++;
      return null;
    }
    int curVal = preorder[pre++];
    TreeNode cur = new TreeNode(curVal);
    cur.left = recursive(preorder, inorder, curVal);
    cur.right = recursive(preorder, inorder, stop);
    return cur;
  }
}
