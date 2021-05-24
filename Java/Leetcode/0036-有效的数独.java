class Solution {
  public boolean isValidSudoku(char[][] board) {
    int[] line = new int[9];
    int[] column = new int[9];
    int[] cell = new int[9];
    int shift = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        // 如果还没有填数字，直接跳过
        if (board[i][j] == '.') continue;
        shift = 1 << (board[i][j] - '0');
        int k = (i / 3) * 3 + j / 3;
        // 如果对应的位置只要有一个大于0，说明有冲突，直接返回false
        if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0) return false;
        column[i] |= shift;
        line[j] |= shift;
        cell[k] |= shift;
      }
    }
    return true;
  }
}
