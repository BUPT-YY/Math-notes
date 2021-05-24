/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    Map<Integer, Node> dict = new HashMap<>();
    Set<Integer> path = new HashSet<>();
    return cloneGraph(node, dict, path);
  }

  private Node cloneGraph(Node node, Map<Integer, Node> dict, Set<Integer> path) {
    Node newNode = dict.get(node.val);

    if (newNode == null) {
      newNode = new Node(node.val);
      dict.put(node.val, newNode);
    } else {
      return newNode;
    }

    if (node.neighbors != null && node.neighbors.size() > 0) {
      for (Node neighbor : node.neighbors) {
        Node newNeighbor = cloneGraph(neighbor, dict, path);
        newNode.neighbors.add(newNeighbor);
      }
    }

    path.add(node.val);

    return newNode;
  }
}
