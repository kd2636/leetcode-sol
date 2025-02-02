class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1];
        return f(0, -1, nums, dp);
    }

    // f(i, prev_i) -> return LIS starting from i till last when the previous element index is prev_i
    private int f(int i, int prev_i, int[] nums, Integer[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prev_i + 1] != null) return dp[i][prev_i + 1];

        int nt = f(i + 1, prev_i, nums, dp);

        int t = 0;
        if (prev_i == - 1 || nums[i] > nums[prev_i]) {
            t = 1 + f(i + 1, i, nums, dp);
        }

        return dp[i][prev_i + 1] = Math.max(nt, t);
    }
}