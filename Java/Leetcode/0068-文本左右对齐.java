class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int lineStartIndex = 0;
    int currIndex = 0;
    int lineTotleChars = 0;
    while (currIndex < words.length) {
      String currString = words[currIndex];
      if (lineTotleChars + currString.length() > maxWidth) {
        int cs = currIndex - lineStartIndex;
        int leftSpace = maxWidth - lineTotleChars + cs;
        StringBuffer buf = new StringBuffer();
        for (int i = lineStartIndex; i < currIndex; i++) {
          buf.append(words[i]);
          if (i != currIndex - 1) {
            int printSpace = leftSpace / (cs - 1);
            if (printSpace < (leftSpace - (leftSpace / (cs - 1) * (cs - 2)))) {
              printSpace++;
            }
            for (int j = 0; j < printSpace; j++) {
              buf.append(' ');
            }
            cs--;
            leftSpace = leftSpace - printSpace;
          }

          if (lineStartIndex + 1 == currIndex) {
            for (int j = 0; j < maxWidth - words[i].length(); j++) {
              buf.append(' ');
            }
          }
        }
        result.add(buf.toString());
        lineStartIndex = currIndex;
        lineTotleChars = currString.length() + 1;
      } else {
        lineTotleChars += currString.length() + 1;
      }
      currIndex++;
    }

    StringBuffer buf = new StringBuffer();
    for (int i = lineStartIndex; i < currIndex; i++) {
      buf.append(words[i]);
      if (i != currIndex - 1) {
        buf.append(' ');
      }
    }
    for (int i = 0; i < maxWidth - lineTotleChars + 1; i++) {
      buf.append(' ');
    }
    result.add(buf.toString());
    return result;
  }
}
