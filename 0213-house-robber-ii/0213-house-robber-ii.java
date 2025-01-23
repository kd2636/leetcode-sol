class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][2];
        // isFirstTaken - 0 (false), 1(true)
        return robHelper(n - 1, nums, 0, dp);
    }

    // f(i) -> returns maximum sum for index 0 to i of nums.
    private int robHelper(int i, int[] nums, int isFirstTaken, Integer[][] dp) {

        if (i == 0) {
            if (isFirstTaken == 1) {
                return 0;
            } else {
                return nums[0];
            }
            
        }

        if (i < 0) {
            return 0;
        }
        if (dp[i][isFirstTaken] != null) return dp[i][isFirstTaken];
        
        int pick = nums[i] + robHelper(i - 2, nums, i == nums.length - 1 ? 1 : isFirstTaken, dp);
        int notPick = robHelper(i - 1, nums, isFirstTaken, dp);

        return dp[i][isFirstTaken] = Math.max(pick, notPick);

    }
}