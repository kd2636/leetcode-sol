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

        // tabulation soln - 

        int[] dp = new int[targetSum + 1];
        if (nums[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
        }
        if (nums[0] != 0 && nums[0] <= targetSum) {
            dp[nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = targetSum; j >= 0; j--) {
                int nt = dp[j];

                int t = 0;
                if (nums[i] <= j) {
                    t = dp[j - nums[i]];
                }
                dp[j] = nt + t;
            }
        }
        return dp[targetSum];
    }

}