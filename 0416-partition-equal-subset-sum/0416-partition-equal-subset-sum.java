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
        Boolean[][] dp = new Boolean[n][k + 1];
        return f(n - 1, k, nums, dp);
    }

    // f(i, k) -> return whether there is a subset with sum k from 0 to i;
    private boolean f(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == 0) {
            if (nums[i] == target) return true;
            else return false;
        }

        if (dp[i][target] != null) return dp[i][target];
        // not take
        if (f(i - 1, target, nums, dp)) {
            return dp[i][target] = true;
        }

        // take
        if (target >= nums[i]) {
            if (f(i - 1, target - nums[i], nums, dp)) {
                return dp[i][target] = true;
            }
        }

        return dp[i][target] = false;

    }
}