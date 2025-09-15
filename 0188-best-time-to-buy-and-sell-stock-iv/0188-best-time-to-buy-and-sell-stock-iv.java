class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int x = 1; x <= k; x++) {
                    if (j == 0) {
                        // can buy
                        dp[i][j][x] = Math.max(dp[i + 1][0][x], -prices[i] + dp[i + 1][1][x]);
                    } else {
                        // can sell only
                        dp[i][j][x] = Math.max(dp[i + 1][1][x], prices[i] + dp[i + 1][0][x - 1]);
                    }
                }
            }
        }

        return dp[0][0][k];
        
    }
}