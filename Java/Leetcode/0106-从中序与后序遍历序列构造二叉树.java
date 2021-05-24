class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    TreeNode root = fun(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    return root;
  }

  private TreeNode fun(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
    if (il > ir || pl > pr) return null;
    TreeNode root = new TreeNode(postorder[pr]);
    for (int i = ir; i >= il; i--) {
      if (inorder[i] == postorder[pr]) {
        TreeNode leftNode = fun(inorder, postorder, il, i - 1, pl, pr - (ir - i) - 1);
        TreeNode rightNode = fun(inorder, postorder, i + 1, ir, pr - (ir - i), pr - 1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
      }
    }
    return root;
  }
}
