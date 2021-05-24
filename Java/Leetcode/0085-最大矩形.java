class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[] dp = new int[n + 1]; // 增加一列，简化边界处理
    int res = 0;
    for (int row = 0; row < m; row++) {
      updateHeight(dp, row, matrix);

      res = Math.max(res, maxArea(dp));
    }
    return res;
  }

  public void updateHeight(int[] dp, int row, char[][] matrix) {
    for (int column = 0; column < matrix[row].length; column++) {
      dp[column] = matrix[row][column] == '1' ? dp[column] + 1 : 0;
    }
  }

  public int maxArea(int[] heights) {
    int l = 0, r = 0;
    int n = heights.length;
    int[] pos = new int[n + 1];
    pos[l] = -1;
    int res = 0;
    while (r < n) {
      while (l > 0 && heights[r] < heights[pos[l]]) {
        int h = heights[pos[l--]];
        res = Math.max(res, h * (r - pos[l] - 1));
      }
      pos[++l] = r++;
    }
    return res;
  }
}
