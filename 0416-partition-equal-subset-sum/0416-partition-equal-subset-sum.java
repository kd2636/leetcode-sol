class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int k = sum / 2;
        return isSubsetSumTarget(nums, k);
    }

    private boolean isSubsetSumTarget(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] -> store if there is a subset with sum j from 0 to i
        boolean[][] dp = new boolean[n][k + 1];
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = true;
            for (int target = 1; target <= k; target++) {
                // not take
                if (dp[i - 1][target]) {
                    dp[i][target] = true;
                } else if (nums[i] <= target && dp[i - 1][target - nums[i]]) {
                    dp[i][target] = dp[i - 1][target - nums[i]];
                } else {
                    dp[i][target] = false;
                }
            }
        }

        return dp[n - 1][k];
        
    }
}