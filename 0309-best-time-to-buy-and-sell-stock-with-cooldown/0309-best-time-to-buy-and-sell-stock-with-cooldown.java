class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][3];
        return f(0, 0, prices, dp);
    }

    // j -> 0 : buy
    // j -> 1 : sell
    // j -> 2 : cooldown
    private int f(int i, int j, int[] prices, Integer[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (j == 0) {
            int a = -prices[i] + f(i + 1, 1, prices, dp);
            int b = f(i + 1, 0, prices, dp);
            return dp[i][j] = Math.max(a, b);
        } else if (j == 1) {
            int a = prices[i] + f(i + 1, 2, prices, dp);
            int b = f(i + 1, 1, prices, dp);
            return dp[i][j] = Math.max(a, b);
        } else {
            return dp[i][j] = f(i + 1, 0, prices, dp);
        }
    }
}