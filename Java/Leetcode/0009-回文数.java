class Solution {
  public boolean isPalindrome(int x) {
    // 当x<0,或者x的最后一位是0且该数不为0时，不成立
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int resvertedNumber = 0;
    while (x > resvertedNumber) {
      resvertedNumber = resvertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == resvertedNumber || x == resvertedNumber / 10;
  }
}
