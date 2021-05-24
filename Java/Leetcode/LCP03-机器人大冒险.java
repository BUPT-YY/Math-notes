class Solution {
  public boolean robot(String command, int[][] obstacles, int x, int y) {
    int U = 0, R = 0;
    char[] csq = command.toCharArray();
    for (char ch : csq) {
      if (ch == 'U') ++U;
      else ++R;
    }

    for (int[] obstacle : obstacles) {
      if (obstacle[0] > x || obstacle[1] > y) continue;

      if (canR(obstacle[0], obstacle[1], R, U, csq)) return false;
    }
    return canR(x, y, R, U, csq);
  }

  boolean canR(int x, int y, int R, int U, char[] sq) {
    int round = Math.min(x / R, y / U);
    int nx = x - round * R, ny = y - round * U;
    if (nx == 0 && ny == 0) return true;
    pre:
    for (int i = 0; i <= 1; ++i) {
      for (char ch : sq) {
        if (ch == 'U') --ny;
        else --nx;
        if (nx == 0 && ny == 0) return true;
        if (nx < 0 || ny < 0) break pre;
      }
    }
    return false;
  }
}
