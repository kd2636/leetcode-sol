class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 0) {
                        int a = -prices[i] + dp[i + 1][1][k];
                        int b = dp[i + 1][0][k];
                        dp[i][j][k] = Math.max(a, b);
                    } else {
                        int a = prices[i] + dp[i + 1][0][k - 1];
                        int b = dp[i + 1][1][k];
                        dp[i][j][k] = Math.max(a, b);
                    }
                }
            }
        }

        return dp[0][0][2];
        
    }
}