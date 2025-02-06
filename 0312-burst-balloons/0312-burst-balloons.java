class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length + 2);
        list.add(1);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.add(1);
        int[][] dp = new int[nums.length + 2][nums.length + 2];

        for (int i = nums.length; i >= 1; i--) {
            for (int j = i; j <= nums.length; j++) {
                int max = 0;
                for (int k = i; k <= j; k++) {
                    int left = dp[i][k - 1];
                    int right = dp[k + 1][j];
                    int curr = list.get(i - 1) * list.get(k) * list.get(j + 1);
                    int total = curr + left + right;
                    max = Math.max(max, total);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][nums.length];
    }

}