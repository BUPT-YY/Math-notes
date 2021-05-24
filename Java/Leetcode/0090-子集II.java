class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> retList = new ArrayList<>();
    retList.add(new ArrayList<>());
    if (nums == null || nums.length == 0) return retList;
    Arrays.sort(nums);

    List<Integer> tmp = new ArrayList<>();
    tmp.add(nums[0]);
    retList.add(tmp);
    if (nums.length == 1) return retList;

    int lastLen = 1;

    for (int i = 1; i < nums.length; i++) {
      int size = retList.size();
      if (nums[i] != nums[i - 1]) {
        lastLen = size;
      }

      for (int j = size - lastLen; j < size; j++) {
        List<Integer> inner = new ArrayList(retList.get(j));
        inner.add(nums[i]);
        retList.add(inner);
      }
    }
    return retList;
  }
}
