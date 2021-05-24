class Solution {
  public String minWindow(String s, String t) {
    char[] chars1 = s.toCharArray();
    char[] chars2 = t.toCharArray();

    int len1 = chars1.length;
    int len2 = chars2.length;

    //      维护两个数组，need表示短串，have表示滑动的窗口
    int[] need = new int[128];
    int[] have = new int[128];

    //        将短串放入到need中，值表示个数
    for (int i = 0; i < len2; i++) {
      need[chars2[i]]++;
    }

    //      窗口的左右指针。。。
    int left = 0, right = 0, count = 0, minLen = len1 + 1, start = 0;

    while (right < len1) {
      //            说明当前字符不在目标字符中，不需要
      if (need[chars1[right]] == 0) {
        right++;
        continue;
      }
      //            执行到这说明，当前字符已经是需要的字符，需要判断当前字符需要的个数
      if (have[chars1[right]] < need[chars1[right]]) {
        //              使用count计数，便于后面对是否全部包括进行判断
        count++;
      }
      have[chars1[right]]++;
      //            还不够，窗口需要继续右移
      right++;
      //          判断窗口是否已经全部包括所需要的字符
      while (count == len2) {
        //                判断当前窗口的长度和最小值哪个更小，对长度更新
        if (right - left < minLen) {
          minLen = right - left;
          start = left;
        }
        //                获取对长串的左边界字符
        //                char l = chars1[left];
        //                左边界字符不是需要的字符，则左边界右移
        if (need[chars1[left]] == 0) {
          left++;
          continue;
        }
        //                左边界字符是需要的字符，破坏循环条件，跳出内层循环，开始外层循环，也就是窗口的右边界继续向右
        if (have[chars1[left]] == need[chars1[left]]) {
          count--;
        }
        have[chars1[left]]--;
        left++;
      }
    }
    //        最小长度还是原始的，那么说明未找到，返回空
    if (minLen == len1 + 1) {
      return "";
    }
    return s.substring(start, start + minLen);
  }
}
