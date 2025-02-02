class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev_i = i - 1; prev_i >= -1; prev_i--) {
                int nt = dp[i + 1][prev_i + 1];

                int t = 0;
                if (prev_i == -1 || nums[i] > nums[prev_i]) {
                    t = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev_i + 1] = Math.max(nt, t);
            }
        }
        return dp[0][0];
    }

}