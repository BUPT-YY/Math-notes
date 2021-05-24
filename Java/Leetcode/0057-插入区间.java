// 类似于merge interval

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();

    if (intervals.length == 0) {
      return new int[][] {newInterval};
    }

    int ind = 0;
    int L = newInterval[0];
    int R = newInterval[1];

    while (ind < intervals.length && intervals[ind][1] < L) {
      res.add(intervals[ind]);
      ind++;
    }

    // Overlap
    while (ind < intervals.length && intervals[ind][0] <= R) {
      L = Math.min(intervals[ind][0], L);
      R = Math.max(intervals[ind][1], R);
      ind++;
    }
    res.add(new int[] {L, R});

    while (ind < intervals.length) {
      res.add(intervals[ind]);
      ind++;
    }

    return res.toArray(new int[res.size()][]);
  }
}
