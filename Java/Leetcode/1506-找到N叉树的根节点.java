/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public Node findRoot(List<Node> tree) {
    int n = tree.size();
    boolean[] flags = new boolean[n]; // 为孩子或null时 = true
    HashSet<Integer> hs = new HashSet<>();
    Iterator<Node> treeIt = tree.iterator();
    for (int i = 0; i < n; ++i) {
      Node node = treeIt.next();
      if (node == null) flags[i] = true;
      for (Node child : node.children) hs.add(Integer.valueOf(child.hashCode()));
    }

    treeIt = tree.iterator();
    for (int i = 0; i < n; ++i) {
      Node node = treeIt.next();
      if (!flags[i] && hs.contains(Integer.valueOf(node.hashCode()))) flags[i] = true;
    }

    for (int i = 0; i < n; ++i) if (!flags[i]) return tree.get(i);
    return tree.get(0);
  }
}
