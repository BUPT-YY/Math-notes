class Solution {
  public String simplifyPath(String path) {
    path += '/';
    char[] s = path.toCharArray();
    int idx = 0;
    for (char c : s) {
      if (idx == 0 || c != '/') {
        s[idx++] = c;
        continue;
      }

      if (s[idx - 1] == '/') {
        continue;
      }

      if (s[idx - 1] == '.' && s[idx - 2] == '/') {
        idx--;
        continue;
      }

      if (s[idx - 1] == '.' && s[idx - 2] == '.' && s[idx - 3] == '/') {
        idx -= 2;
        if (idx != 1) {
          idx--;
          while (s[idx - 1] != '/') {
            idx--;
          }
        }
        continue;
      }

      s[idx++] = c;
    }
    if (idx > 1 && s[idx - 1] == '/') {
      idx--;
    }

    return new String(s, 0, idx);
  }
}
