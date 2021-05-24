class Solution {
  public int numDistinct(String s, String t) {
    if (t.length() > s.length()) {
      return 0;
    }
    char[] source = s.toCharArray();
    char[] match = t.toCharArray();
    int N = source.length, M = match.length;
    int[] dp = new int[M + 1];
    dp[0] = 1;
    int[] map = new int[128];
    Arrays.fill(map, -1);
    int[] next = new int[M];

    for (int i = 0; i < M; i++) {
      int cur = match[i];
      next[i] = map[cur];
      map[cur] = i;
    }
    for (char cur : source) {
      for (int j = map[cur]; j >= 0; j = next[j]) {
        dp[j + 1] += dp[j];
      }
    }
    return dp[M];
  }
}
