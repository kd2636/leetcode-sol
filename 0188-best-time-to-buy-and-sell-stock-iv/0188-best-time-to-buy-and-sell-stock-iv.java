class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int cap = 1; cap <= (2 * k); cap++) {
                if (cap % 2 == 0) {
                    int a = -prices[i] + dp[i + 1][cap - 1];
                    int b = dp[i + 1][cap];
                    dp[i][cap] = Math.max(a, b);
                } else {
                    int a = prices[i] + dp[i + 1][cap - 1];
                    int b = dp[i + 1][cap];
                    dp[i][cap] = Math.max(a, b);
                }
            }
        }
        return dp[0][2 * k];
    }

}