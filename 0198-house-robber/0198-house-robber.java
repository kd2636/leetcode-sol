class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n + 1];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = nums[i] + (i > 1 ? dp[i - 2] : 0);
            int notPick = dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }
}