class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumEqualOrLess(nums, goal) - numSubarraysWithSumEqualOrLess(nums, goal - 1);
    }

    private int numSubarraysWithSumEqualOrLess(int[] nums, int k) {
        if (k < 0) return 0;
        int n = nums.length;
        int count = 0, sum = 0, l = 0, r = 0;

        while (r < n) {
            sum = sum + nums[r];

            while (sum > k) {
                sum = sum - nums[l];
                l++;
            }

            count = count + (r - l + 1);
            r++;
        }
        return count;
    }
}