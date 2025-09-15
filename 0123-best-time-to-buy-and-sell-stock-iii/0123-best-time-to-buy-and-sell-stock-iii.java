class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        Integer[][][] dp = new Integer[n][2][3];
        return f(0, 0, 0, prices, dp);
    }

    private int f(int i, int j, int k, int[] prices, Integer[][][] dp) {
        if (i == prices.length) return 0;
        if (k == 2) return 0;

        if (dp[i][j][k] != null) return dp[i][j][k];

        if (j == 0) {
            // can buy
            return dp[i][j][k] = Math.max(f(i + 1, 0, k, prices, dp), -prices[i] + f(i + 1, 1, k, prices, dp));
        } else {
            // can sell only
            return dp[i][j][k] = Math.max(f(i + 1, 1, k, prices, dp), prices[i] + f(i + 1, 0, k + 1, prices, dp));
        }

    }
}