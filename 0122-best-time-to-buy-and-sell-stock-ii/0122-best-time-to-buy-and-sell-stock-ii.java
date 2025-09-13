class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        Integer[][] dp = new Integer[n][2];
        return f(prices, 0, 0, dp);
    }

    private int f(int[] prices, int i, int j, Integer[][] dp) {
        if (i == prices.length) {
            return 0;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (j == 0) {
            return dp[i][j] = Math.max(f(prices, i + 1, 0, dp), -prices[i] + f(prices, i + 1, 1, dp));
        } else {
            return dp[i][j] = Math.max(f(prices, i + 1, 1, dp), prices[i] + f(prices, i + 1, 0, dp));
        }
    }
}