class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (wordList == null || wordList.size() == 0) {
      return 0;
    }
    HashSet<String> start = new HashSet<>();
    HashSet<String> end = new HashSet<>();
    HashSet<String> dic = new HashSet<>(wordList);
    start.add(beginWord);
    end.add(endWord);
    if (!dic.contains(endWord)) {
      return 0;
    }
    return bfs(start, end, dic, 2);
  }

  public int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
    if (st.size() == 0) {
      return 0;
    }
    if (ed.size() < st.size()) {
      return bfs(ed, st, dic, l);
    }
    // BFS的标记行为，即使用过的不重复使用
    dic.removeAll(st);
    // 收集下一层临近点
    HashSet<String> next = new HashSet<>();
    for (String str : st) {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char nowC = chars[i];
        for (char c = 'a'; c <= 'z'; c++) {
          char now = c;
          if (now == chars[i]) {
            continue;
          }
          chars[i] = now;
          String nowStr = new String(chars);
          if (dic.contains(nowStr)) {
            // 如果在结果集合中存在该改变后的字符串，则表示，当前单词接龙中的所有字符串均已出现，就直接返回长度
            if (ed.contains(nowStr)) {
              return l;
            } else {
              // 存储下一层的全部字符串。
              next.add(nowStr);
            }
          }
        }
        chars[i] = nowC;
      }
    }

    return bfs(next, ed, dic, l + 1);
  }
}
