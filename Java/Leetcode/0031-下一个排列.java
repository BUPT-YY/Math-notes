class Solution {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 1) return;
    int i = nums.length - 1;
    while (i > 0) {
      if (nums[i] > nums[i - 1]) {
        int min = nums[i];
        int k = i;
        for (int j = i + 1; j < nums.length; ++j) {
          if (nums[j] < min && nums[j] > nums[i - 1]) {
            min = nums[j];
            k = j;
          }
        }
        int temp = nums[i - 1];
        nums[i - 1] = nums[k];
        nums[k] = temp;
        Arrays.sort(nums, i, nums.length);
        break;
      }
      --i;
    }
    if (i == 0) {
      Arrays.sort(nums);
    }
  }
}
