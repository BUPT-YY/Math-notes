class Solution {
  int len1;
  int len2;
  int len;
  boolean[][] visited;

  public boolean isInterleave(String s1, String s2, String s3) {
    len1 = s1.length();
    len2 = s2.length();
    len = s3.length();
    if (len1 + len2 != len) return false;
    visited = new boolean[len1 + 1][len2 + 1];

    return dfs(s1, s2, s3, 0, 0, 0);
  }

  public boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
    if (k == len) return true;
    if (visited[i][j]) return false;

    visited[i][j] = true;

    boolean f1 = false, f2 = false;
    if (i < len1 && s1.charAt(i) == s3.charAt(i + j)) {
      f1 = dfs(s1, s2, s3, i + 1, j, k + 1);
    }
    if (j < len2 && s2.charAt(j) == s3.charAt(i + j)) {
      f2 = dfs(s1, s2, s3, i, j + 1, k + 1);
    }

    if (f1 || f2) return true;
    return false;
  }
}
