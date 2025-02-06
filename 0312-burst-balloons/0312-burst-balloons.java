class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length + 2);
        list.add(1);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.add(1);
        Integer[][] dp = new Integer[nums.length + 1][nums.length + 1];

        return f(1, nums.length, list, dp);
    }

    private int f(int i, int j, List<Integer> nums, Integer[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int max = 0;
        for (int k = i; k <= j; k++) {
            int left = f(i, k - 1, nums, dp);
            int right = f(k + 1, j, nums, dp);
            int curr = nums.get(i - 1) * nums.get(k) * nums.get(j + 1);
            int total = curr + left + right;
            max = Math.max(max, total);
        }
        return dp[i][j] = max;
    }
}