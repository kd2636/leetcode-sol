class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // problem can be boiled down to finding two subsets with diff d.
        // s1 - s2 = d
        // s1 - (totalSum - s1) = d
        // s1 = (d + totalSum) / 2
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        int d = target;
        if (target < 0) d = -1 * target;
        
        if ((d + sum) % 2 != 0) return 0;
        int targetSum = (d + sum) / 2;
        Integer[][] dp = new Integer[n][targetSum + 1];
        return f(n - 1, targetSum, nums, dp);
    }

    // f(i, target) -> return count of subsets from 0 to i with sum = target
    private int f(int i, int target, int[] nums, Integer[][] dp) {
        if (i == 0) {
            if (target == 0 && nums[0] == target) return 2;
            if (target == 0) return 1;
            if (target == nums[i]) return 1;
            return 0;
        }

        if (dp[i][target] != null) return dp[i][target];

        int nt = f(i - 1, target, nums, dp);

        int t = 0;
        if (nums[i] <= target) {
            t = f(i - 1, target - nums[i], nums, dp);
        }

        return dp[i][target] = nt + t;
    }
}