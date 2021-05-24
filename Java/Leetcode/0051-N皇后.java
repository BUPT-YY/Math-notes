class Solution {
  public List<List<String>> solveNQueens(int n) {
    if (n == 1) return new ArrayList<>(Arrays.asList(new ArrayList<String>(Arrays.asList("Q"))));
    List<List<String>> result = new ArrayList<>();
    if (n == 2 || n == 3) return result;
    int[] data = new int[n]; // 每列的皇后位置
    Arrays.fill(data, -1);
    for (int i = 0; i < n; ) {
      ++data[i];
      if (!check(data, i)) continue;
      if (data[i] >= n) {
        if (i == 0) break;
        data[i--] = -1;
      } else ++i;
      if (i == n) {
        result.add(convert(data));
        data[n - 1] = -1;
        i = n - 2;
      }
    }
    return result;
  }

  private List<String> convert(int[] data) {
    List<String> subRes = new ArrayList<String>();
    char[] res = new char[data.length];
    Arrays.fill(res, '.');
    for (int j = 0; j < data.length; ++j) {
      res[data[j]] = 'Q';
      subRes.add(new String(res));
      res[data[j]] = '.';
    }
    return subRes;
  }

  private boolean check(int[] data, int index) {
    if (data[index] == -1) return false;
    for (int i = 0; i < data.length; ++i) {
      if (i == index) continue;
      if (data[i] == data[index]
          || (data[i] >= 0
              && ((i + data[i] == index + data[index]) || (i + data[index] == index + data[i]))))
        return false;
    }
    return true;
  }
}
