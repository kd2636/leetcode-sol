class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return f(0, 0, prices, fee, dp);
    }

    private int f(int i, int j, int[] prices, int fee, Integer[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (j == 0) {
            int a = -prices[i] - fee + f(i + 1, 1, prices, fee, dp);
            int b = f(i + 1, 0, prices, fee, dp);
            return dp[i][j] = Math.max(a, b);
        } else {
            int a = prices[i] + f(i + 1, 0, prices, fee, dp);
            int b = f(i + 1, 1, prices, fee, dp);
            return dp[i][j] = Math.max(a, b);
        }
    }
}