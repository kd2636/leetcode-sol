class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[nums.length];

        // f(i) : 0 to n
        return f(nums, nums.length - 1, dp);
    }

    private int f(int[] nums, int i, Integer[] dp) {
        if (i == 0) {
            return nums[0];
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i] != null) return dp[i];

        int pick = nums[i] + f(nums, i - 2, dp);
        int notPick = f(nums, i - 1, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}