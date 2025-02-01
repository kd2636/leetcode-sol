class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    int a = (-1 * prices[i]) + dp[i + 1][1];
                    int b = dp[i + 1][0];
                    dp[i][j] = Math.max(a, b);
                } else {
                    int a = prices[i] + dp[i + 1][0];
                    int b = dp[i + 1][1];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }

        return dp[0][0];
    }

}