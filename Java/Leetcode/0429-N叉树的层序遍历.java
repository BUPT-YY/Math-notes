/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    List<Node> currlevel = new LinkedList<Node>();
    currlevel.add(root);

    while (!currlevel.isEmpty()) {
      List<Node> nextlevel = new LinkedList<Node>();
      List<Integer> subRes = new ArrayList<>();
      for (Node node : currlevel) {
        subRes.add(Integer.valueOf(node.val));
        for (Node child : node.children) {
          nextlevel.add(child);
        }
      }
      result.add(subRes);
      currlevel = nextlevel;
    }
    return result;
  }
}
