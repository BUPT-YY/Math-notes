class Solution {
  public int[] maximizeXor(int[] nums, int[][] queries) {
    int n = nums.length, m = queries.length;
    int[] ans = new int[m];
    int[][] newqueries = new int[m][3];
    for (int i = 0; i < m; ++i) {
      newqueries[i][0] = queries[i][0];
      newqueries[i][1] = queries[i][1];
      newqueries[i][2] = i;
    }
    Arrays.sort(nums);
    int minele = nums[0];

    Arrays.sort(newqueries, (a, b) -> a[1] - b[1]);
    TrieNode root = new TrieNode();
    int i = 0;
    for (int[] q : newqueries) {
      if (q[1] < minele) {
        ans[q[2]] = -1;
        continue;
      }
      while (i < n && nums[i] <= q[1]) {
        TrieNode node = root;
        for (int k = 31; k >= 0; --k) {
          int temp = (nums[i] >> k) & 1;
          if (node.next[temp] == null) {
            node.next[temp] = new TrieNode();
          }
          node = node.next[temp];
        }
        ++i;
      }
      TrieNode node = root;
      int ret = 0;
      for (int k = 31; k >= 0; --k) {
        if (node.next[1 - ((q[0] >> k) & 1)] != null) {
          node = node.next[1 - ((q[0] >> k) & 1)];
          ret *= 2;
          ++ret;
        } else {
          node = node.next[(q[0] >> k) & 1];
          ret *= 2;
        }
      }
      ans[q[2]] = ret;
    }
    return ans;
  }
}

class TrieNode {
  TrieNode[] next = new TrieNode[2];
}
