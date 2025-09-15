class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        Integer[][] dp = new Integer[n][2];
        return f(0, 0, prices, dp);
    }

    private int f(int i, int j, int[] prices, Integer[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (j == 0) {
            return dp[i][j] = Math.max(f(i + 1, 0, prices, dp), -prices[i] + f(i + 1, 1, prices, dp));
        } else {
            return dp[i][j] = Math.max(f(i + 1, 1, prices, dp), prices[i] + f(i + 2, 0, prices, dp));
        }
    }
}