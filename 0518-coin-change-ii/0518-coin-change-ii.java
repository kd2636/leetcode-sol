class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return f(n - 1, amount, coins, dp);
    }

    private int f(int i, int amt, int[] coins, Integer[][] dp) {
        if (i == 0) {
           if (amt % coins[i] == 0) {
            return 1;
           } else {
            return 0;
           }
        }

        if (dp[i][amt] != null) return dp[i][amt];

        int notTake = f(i - 1, amt, coins, dp);
        int take = 0;
        if (coins[i] <= amt) {
            take = f(i, amt - coins[i], coins, dp);
        }
        return dp[i][amt] = take + notTake;
    }
}