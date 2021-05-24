class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combine = new ArrayList<>();
    List<Integer> one = new ArrayList<>();
    backtracking(one, combine, 1, k, n);
    return combine;
  }

  private void backtracking(
      List<Integer> one, List<List<Integer>> all, int start, int k, final int n) {
    if (k == 0) {
      all.add(new ArrayList<>(one));
      return;
    }

    for (int i = start; i <= n - k + 1; i++) {
      one.add(i);
      backtracking(one, all, i + 1, k - 1, n);
      one.remove(one.size() - 1);
    }
  }
}
