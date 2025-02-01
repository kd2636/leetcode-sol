class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];

        return f(0, 0, 2, prices, dp);
        
    }
    // f(i, j, cap) -> returns max profit from i to n - 1 when staring with for total cap transactions
    // j -> 0 : to buy
    // j -> 1 : to sell
    private int f(int i, int j, int cap, int[] prices, Integer[][][] dp) {
        if (cap == 0) return 0;
        if (i == prices.length) return 0;

        if (dp[i][j][cap] != null) return dp[i][j][cap];

        if (j == 0) {
            int a = -prices[i] + f(i + 1, 1, cap, prices, dp);
            int b = f(i + 1, 0, cap, prices, dp);
            return dp[i][j][cap] = Math.max(a, b);
        } else {
            int a = prices[i] + f(i + 1, 0, cap - 1, prices, dp);
            int b = f(i + 1, 1, cap, prices, dp);
            return dp[i][j][cap] = Math.max(a, b);
        }
    }
}