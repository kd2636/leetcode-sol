class Solution {
    public boolean check(int[] nums) {
        int inflictionCount = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                inflictionCount++;
            }
        }
        if (inflictionCount == 0) return true;
        if (inflictionCount > 1) return false;
        return nums[n - 1] <= nums[0] ? true : false;
    }
}