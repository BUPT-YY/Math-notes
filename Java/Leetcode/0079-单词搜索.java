class Solution {
  boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    // 传说中的剪枝
    char[] ch = word.toCharArray();
    int n1 = ch.length;
    int m1 = board.length;
    int m2 = board[0].length;
    if (n1 > m1 * m2) {
      return false;
    }

    int[] f1 = new int[133];
    int[] f2 = new int[133];
    for (int i = 0; i < m1; i++) {
      for (int j = 0; j < m2; j++) {
        ++f1[board[i][j]];
      }
    }

    for (int i = 0; i < n1; i++) {
      ++f2[ch[i]];
    }

    for (int i = 0; i < 133; i++) {
      if (f1[i] < f2[i]) {
        return false;
      }
    }
    // 我的解法，我的解法是完全对的，但是缺乏上面的剪枝，执行太慢了
    int m = board.length, n = board[0].length;
    visited = new boolean[m][n];
    boolean res = false;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res = recur(board, word, i, j, 0);
        if (res) return res; // 如果是break就只能跳出当前的循环。
      }
    }
    return res;
  }

  private boolean recur(char[][] board, String word, int i, int j, int index) {
    // 检查字符串是否匹配完毕
    if (index == word.length()) return true;
    // 检查当前位置是否可以访问
    int m = board.length, n = board[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n) return false;

    boolean res = false;
    if (!visited[i][j] && board[i][j] == word.charAt(index)) {
      visited[i][j] = true;
      index++;
      res =
          recur(board, word, i - 1, j, index)
              || recur(board, word, i + 1, j, index)
              || recur(board, word, i, j - 1, index)
              || recur(board, word, i, j + 1, index);
      visited[i][j] = false;
    }
    return res;
  }
}
