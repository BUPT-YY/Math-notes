class Solution {
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    // a-z 97-122
    // A-Z 65-90
    // 0-9 48-57
    while (right > left) {
      int lc = s.charAt(left);
      int rc = s.charAt(right);
      if (lc >= 97 && lc <= 122) {
        lc -= 32;
      } else if (lc < 48 || lc > 57 && lc < 65 || lc > 90) {
        left++;
        continue;
      }
      if (rc >= 97 && rc <= 122) {
        rc -= 32;
      } else if (rc < 48 || rc > 57 && rc < 65 || rc > 90) {
        right--;
        continue;
      }
      if (lc != rc) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
