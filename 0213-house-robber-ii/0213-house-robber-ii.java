class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][2];
        return robHelper(n - 1, nums, false, dp);
    }

    // f(i) -> returns maximum sum for index 0 to i of nums.
    private int robHelper(int i, int[] nums, boolean isFirstTaken, Integer[][] dp) {

        if (i == 0) {
            if (isFirstTaken) {
                return 0;
            } else {
                return nums[0];
            }
            
        }

        if (i < 0) {
            return 0;
        }
        if (dp[i][isFirstTaken ? 1 : 0] != null) return dp[i][isFirstTaken ? 1 : 0];
        
        int pick = nums[i] + robHelper(i - 2, nums, i == nums.length - 1 ? true : isFirstTaken, dp);
        int notPick = robHelper(i - 1, nums, isFirstTaken, dp);

        return dp[i][isFirstTaken ? 1 : 0] = Math.max(pick, notPick);

    }
}