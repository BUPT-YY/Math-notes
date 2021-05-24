class Solution {
  List<String> res = new ArrayList<>();
  int[] tmp = new int[4];

  public List<String> restoreIpAddresses(String s) {
    if (s.length() < 4) {
      return res;
    }
    helper(s, 0, 0, 0);
    return res;
  }

  private void helper(String s, int len, int index, int count) {
    if (len == 4) { // 刚好用完,则添加进去
      if (count < s.length()) { // 如果字符没用完，说明不行
        return;
      }
      StringBuilder tmp2 = new StringBuilder();
      for (int i = 0; i < 4; i++) {
        tmp2.append(tmp[i]);
        tmp2.append(".");
      }
      tmp2.deleteCharAt(tmp2.length() - 1);
      res.add(tmp2.toString());
      return;
    }

    int ip = 0; // 判定每一个的值

    for (int i = index; i < index + 3 && i < s.length(); i++) { // 最多选取依次的三个
      count += 1; // 记录用了多少个
      if (i == index && s.charAt(i) == '0') { // 0开头？那么只能循环一次
        tmp[len] = 0;
        helper(s, len + 1, i + 1, count);
        return;
      }
      ip = ip * 10 + (s.charAt(i) - 48); // ip值的计算
      if (ip > 255) {
        break;
      }
      tmp[len] = ip;
      helper(s, len + 1, i + 1, count);
    }
  }
}
