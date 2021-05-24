class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      if (target - nums[i] > 3 * nums[n - 1]) continue;
      if (target - nums[i] < 3 * nums[i + 1]) break;
      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        int t = target - nums[i] - nums[j];
        if (t > 2 * nums[n - 1]) continue;
        if (t < 2 * nums[j + 1]) {
          break;
        }
        int k = j + 1;
        int m = n - 1;
        while (k < m) {
          if (nums[k] + nums[m] < t) {
            k++;
          } else if (nums[k] + nums[m] > t) {
            m--;
          } else {
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[i]);
            list1.add(nums[j]);
            list1.add(nums[k]);
            list1.add(nums[m]);
            list.add(list1);
            while (k < m - 1 && nums[k] == nums[k + 1]) {
              k++;
            }
            while (m > k + 1 && nums[m] == nums[m - 1]) {
              m--;
            }
            k++;
            m--;
          }
        }
      }
    }
    return list;
  }
}
