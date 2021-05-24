class Solution {
  int n;
  int m;

  public int domino(int n, int m, int[][] broken) {
    int[][] board = new int[n][m];
    int[] match = new int[m * n];
    boolean[] visited = new boolean[m * n];
    this.n = n;
    this.m = m;
    for (int[] b : broken) {
      board[b[0]][b[1]] = -1;
    }
    Arrays.fill(match, -1);
    int count = 0;
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        if ((x + y) % 2 == 1 || board[x][y] == -1) continue;
        Arrays.fill(visited, false);
        if (find(match, visited, x, y, board)) {
          count++;
        }
      }
    }
    return count;
  }

  public boolean find(int[] match, boolean[] visited, int x, int y, int[][] board) {
    int[] xdiff = {0, 1, 0, -1};
    int[] ydiff = {-1, 0, 1, 0};
    for (int i = 0; i < 4; i++) {
      int nx = x + xdiff[i];
      int ny = y + ydiff[i];
      if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
      if (board[nx][ny] == -1) continue;
      int index = nx * m + ny;
      if (visited[index]) continue;
      visited[index] = true;
      if (match[index] == -1 || find(match, visited, match[index] / m, match[index] % m, board)) {
        match[index] = x * m + y;
        return true;
      }
    }
    return false;
  }
}
