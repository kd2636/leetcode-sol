class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2 * k + 1];
        return f(0, 2 * k, prices, dp);
    }

    // f(i, cap) -> return max profit from i to n with cap transactions.
    // cap -> even : buy
    // cap -> odd : sell
    private int f(int i, int cap, int[] prices, Integer[][] dp) {
        if (cap == 0 || i == prices.length) {
            return 0;
        }
        if (dp[i][cap] != null) return dp[i][cap];
        if (cap % 2 == 0) {
            int a = -prices[i] + f(i + 1, cap - 1, prices, dp);
            int b = f(i + 1, cap, prices, dp);
            return dp[i][cap] = Math.max(a, b);
        } else {
            int a = prices[i] + f(i + 1, cap - 1, prices, dp);
            int b = f(i + 1, cap, prices, dp);
            return dp[i][cap] = Math.max(a, b);
        }
    }
}