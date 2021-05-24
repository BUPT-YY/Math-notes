class Solution {
  List<String> res = new ArrayList<>();
  int count;

  public List<String> generateParenthesis(int n) {

    if (n <= 0) {
      return res;
    }

    this.count = n;
    dfs(0, 0, 0, new char[2 * n]);
    return res;
  }

  private void dfs(int n, int left, int right, char[] container) {

    if (n == 2 * count) {
      res.add(new String(container));
      return;
    }

    if (left < count) {
      container[n] = '(';
      dfs(n + 1, left + 1, right, container);
    }

    if (right < left) {
      container[n] = ')';
      dfs(n + 1, left, right + 1, container);
    }
  }
}
