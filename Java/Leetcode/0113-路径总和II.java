/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    if (root.val == sum && root.left == null && root.right == null) {
      List<Integer> arr = new ArrayList<>();
      arr.add(root.val);
      ans.add(arr);
      return ans;
    }
    List<List<Integer>> left = pathSum(root.left, sum - root.val);
    List<List<Integer>> right = pathSum(root.right, sum - root.val);
    for (List<Integer> list : left) {
      list.add(0, root.val);
      ans.add(list);
    }
    for (List<Integer> list : right) {
      list.add(0, root.val);
      ans.add(list);
    }
    return ans;
  }
}
