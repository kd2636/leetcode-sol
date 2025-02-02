class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // special solution, useful for backtrack to get LIS

        // dp[i] -> store LIS for LIS ending at i.
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}