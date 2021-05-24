class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int row = triangle.size();

    // 记录最后一行数组的值（行数和列数相等）
    int[] cache = new int[row];
    for (int k = 0; k < row; k++) {
      cache[k] = triangle.get(row - 1).get(k);
    }

    // 从倒数第二行数组开始遍历
    for (int i = row - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        cache[j] = Math.min(cache[j], cache[j + 1]) + triangle.get(i).get(j);
      }
    }
    return cache[0];
  }
}
