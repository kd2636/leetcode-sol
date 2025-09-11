class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = 1;
            } else {
                dp[0][amt] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int amt = 0; amt <= amount; amt++) {
                int notTake = dp[i - 1][amt];
                int take = 0;
                if (coins[i] <= amt) {
                    take = dp[i][amt - coins[i]];
                }
                dp[i][amt] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }

}