class Solution {
  public int minPathSum(int[][] grid) {
    int width = grid[0].length, high = grid.length;
    if (high == 0 || width == 0) return 0;
    // 初始化
    for (int i = 1; i < high; i++) grid[i][0] += grid[i - 1][0];
    for (int i = 1; i < width; i++) grid[0][i] += grid[0][i - 1];
    for (int i = 1; i < high; i++)
      for (int j = 1; j < width; j++) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    return grid[high - 1][width - 1];
  }
}
