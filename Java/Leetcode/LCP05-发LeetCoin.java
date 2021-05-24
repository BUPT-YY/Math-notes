import java.util.ArrayList;
import java.util.List;

class Solution {
  class Bit {
    long[] tree;

    public Bit(int n) {
      tree = new long[n + 1];
    }

    public void add(int i, long val) {
      i++;
      while (i < tree.length) {
        tree[i] += val;
        i += i & -i;
      }
    }

    public long query(int i) {
      i++;
      long res = 0;
      while (i > 0) {
        res += tree[i];
        i -= i & -i;
      }
      return res;
    }
  }

  int[] arIn, arOut;
  Bit tree1, tree2;
  int idx = 0, mod = 1_000_000_007;
  List<Integer>[] edges;

  public int[] bonus(int n, int[][] leadership, int[][] operations) {
    edges = new ArrayList[n];
    for (int i = 0; i < n; ++i) {
      edges[i] = new ArrayList<>();
    }
    for (int[] l : leadership) {
      edges[l[0] - 1].add(l[1] - 1);
    }

    arIn = new int[n];
    arOut = new int[n];
    dfs(0);
    tree1 = new Bit(n);
    tree2 = new Bit(n);

    List<Integer> res = new ArrayList<>();
    for (int j = 0; j < operations.length; ++j) {
      int[] op = operations[j];
      int a = op[1] - 1;
      if (op[0] == 1) {
        add(arIn[a], arIn[a], op[2]);
      } else if (op[0] == 2) {
        add(arIn[a], arOut[a], op[2]);
      } else {
        res.add((int) sum(arIn[a], arOut[a]));
      }
    }
    int[] ans = new int[res.size()];
    for (int j = 0; j < res.size(); ++j) {
      ans[j] = res.get(j);
    }
    return ans;
  }

  private void add(int l, int r, int v) {
    tree1.add(l, v);
    tree1.add(r + 1, -v);
    tree2.add(l, v * (l - 1));
    tree2.add(r + 1, -v * r);
  }

  private long sum(int l, int r) {
    l--;
    long sum =
        ((tree1.query(r) * r - tree2.query(r)) - (tree1.query(l) * l - tree2.query(l))) % mod;
    return sum;
  }

  private void dfs(int a) {
    arIn[a] = idx;
    idx++;
    for (int b : edges[a]) {
      dfs(b);
    }
    arOut[a] = idx - 1;
  }
}
