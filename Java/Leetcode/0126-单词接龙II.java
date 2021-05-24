class Solution {
  List<List<String>> graph = new ArrayList<>();
  Map<String, Integer> hash = new HashMap<>();
  List<String> words = new ArrayList<>();
  List<List<String>> result = new ArrayList<>();
  int[] visited;
  int idCount = 0;

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    for (String word : wordList) { // 创建图
      updateGraph(word);
    }
    updateGraph(beginWord); // 将起点加入图
    if (!hash.containsKey(endWord)) { // 如果end节点不在图中，直接返回
      return result;
    }
    LinkedList<List<String>> queue = new LinkedList<>(); // 创建广度优先队列
    List<String> l = new ArrayList<>();
    l.add(beginWord);
    queue.add(l); // 将初始节点加入队列
    boolean isEndLevel = false; // 结束标志
    visited = new int[idCount];
    Arrays.fill(visited, Integer.MAX_VALUE);
    while (queue.size() > 0 && !isEndLevel) { // 如果队列大于0，且结束标志不为真
      int size = queue.size(); // 计算此次广度优先遍历的大小
      for (int i = 0; i < size; i++) { // 计算此层遍历
        List<String> list = queue.poll(); // 获取当前节点所在的集合
        String last = list.get(list.size() - 1); // 取当前节点
        for (String s : graph.get(hash.get(last))) { // 获取当前节点所有可达的下一个节点
          if (visited[hash.get(s)] < list.size()) // 如果此节点的代价小于当前集合长度 则该集合必定不是最短，踢出
          continue;
          List<String> cp = new ArrayList<>(list); // 拷贝一个集合
          cp.add(s); // 将当前节点的下一个节点放入节点集合中
          if (s.equals(endWord)) { // 如果下一个节点为结束节点
            result.add(cp); // 将节点集合放入输出
            isEndLevel = true; // 设置结束标志为真
          } else {
            visited[hash.get(s)] =
                visited[hash.get(s)] > list.size()
                    ? list.size()
                    : visited[hash.get(s)]; // 设置当前访问节点的代价，即最少需要几次
            queue.add(cp); // 将节点集合重新加入队列
          }
        }
      }
    }
    return result;
  }

  void updateGraph(String word) { // 更新图
    if (!hash.containsKey(word)) { // 如果该单词未加入图中
      graph.add(new ArrayList());
      hash.put(word, idCount);
      words.add(word);
      for (int i = 0; i < idCount; i++) { // 比较图中每个单词是否与该单词相差1
        if (compare(words.get(i), word)) { // 如果相差1，连线两个单词
          graph.get(i).add(word);
          graph.get(idCount).add(words.get(i));
        }
      }
      idCount++;
    }
  }

  boolean compare(String word1, String word2) {
    int count = 0;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(i)) count++;
      if (count > 1) return false;
    }
    if (count == 0) return false;
    else return true;
  }
}
