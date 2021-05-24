class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int l1 = num1.length(), l2 = num2.length();
    int[] num = new int[l1 + l2];
    for (int i = l1 - 1; i >= 0; i--) {
      int n1 = num1.charAt(i) - '0';
      for (int j = l2 - 1; j >= 0; j--) {
        int n2 = num2.charAt(j) - '0';
        num[i + j + 1] += n1 * n2;
      }
    }
    for (int i = l1 + l2 - 1; i > 0; i--) {
      num[i - 1] += num[i] / 10;
      num[i] %= 10;
    }
    int index = num[0] == 0 ? 1 : 0;
    StringBuffer res = new StringBuffer();
    while (index < l1 + l2) {
      res.append(num[index]);
      index++;
    }
    return res.toString();
  }
}
