class Solution {
  public String countAndSay(int n) {
    if (n == 1) return "1";
    else {
      String str = countAndSay(n - 1);
      StringBuilder sb = new StringBuilder();
      int fast = 0, slow = 0;
      while (fast < str.length()) {
        if (str.charAt(fast) != str.charAt(slow)) {
          // fast-slow为slow指向的数字连续出现的次数
          sb.append(fast - slow).append(str.charAt(slow));
          slow = fast;
        }
        fast++;
      }
      sb.append(fast - slow).append(str.charAt(slow));
      return sb.toString();
    }
  }
}
