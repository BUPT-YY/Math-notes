class Solution {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    if (n >= 500000) {
      return 500001;
    }
    int[] arr = new int[301];
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0 && nums[i] < 301) {
        arr[nums[i]] = 1;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (arr[i] != 1) {
        return i;
      }
    }
    return n + 1;
  }
}
