class Solution {
    public int rob(int[] nums) {
        // 0 : prev not robbed
        // 1 : prev robbed
        Integer[][] dp = new Integer[nums.length][2];

        return helper(nums, nums.length - 1, 0, dp);
    }

    private int helper(int[] nums, int ind, int r, Integer[][] dp) {
        if (ind == 0) {
            if (r == 0) return nums[0];
            return 0;
        }

        if (dp[ind][r] != null) return dp[ind][r];

        int max = Integer.MIN_VALUE;
        if (r == 1) {
            int a = helper(nums, ind - 1, 0, dp);
            max = Math.max(max, a);
        } else {
            int a = nums[ind] + helper(nums, ind - 1, 1, dp);
            int b = helper(nums, ind - 1, 0, dp);
            max = Math.max(max, a);
            max = Math.max(max, b);
        }

        return dp[ind][r] = max;
    }
}