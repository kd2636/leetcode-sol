class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return f(n - 1, amount, coins, dp);
    }

    private int f(int i, int amount, int[] coins, Integer[][] dp) {
        if (i == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }

        if (dp[i][amount] != null) return dp[i][amount];

        int np = f(i - 1, amount, coins, dp);

        int p = 0;
        if (coins[i] <= amount) {
            p = f(i, amount - coins[i], coins, dp);
        }

        return dp[i][amount] = p + np;
    }
}