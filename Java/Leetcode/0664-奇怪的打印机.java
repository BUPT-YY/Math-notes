class Solution {
  public int strangePrinter(String s) {
    int n = s.length();
    char[] chs = s.toCharArray();
    // dp[i][j]表示打印s中从j~i需要的最少次数
    int[][] dp = new int[n][n];
    // 初始化dp
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      dp[i][i] = 1; // 只有自己一个字符的时候初始化为1
    }
    // j   k   i
    for (int i = 1; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (chs[j] == chs[j + 1]) {
          dp[i][j] = dp[i][j + 1];
          continue;
        } else {
          dp[i][j] = dp[i][j + 1] + 1;
        }
        for (int k = j + 1; k <= i; k++) {
          if (chs[j] == chs[k]) { // 往后面合                         往前面合
            dp[i][j] =
                Math.min(
                    dp[i][j],
                    Math.min(
                        dp[i][k] + dp[k - 1][j + 1], dp[k][j + 1] + dp[i][Math.min(k + 1, i)]));
          }
        }
      }
    }
    return dp[n - 1][0];
  }
}
