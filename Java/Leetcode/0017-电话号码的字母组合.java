class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) {
      return result;
    }
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder stringBuilder = new StringBuilder();
    backtracking(digits, result, map, stringBuilder, 0);
    return result;
  }

  private void backtracking(
      String digits, List<String> result, String[] map, StringBuilder sb, int index) {
    if (index == digits.length()) {
      result.add(new String(sb));
      return;
    }
    int digit = digits.charAt(index) - '0';
    String letters = map[digit];
    for (int i = 0; i < letters.length(); i++) {
      sb.append(letters.charAt(i));
      backtracking(digits, result, map, sb, index + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
