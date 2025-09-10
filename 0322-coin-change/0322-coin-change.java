class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            dp[0] = 0;
            for (int amt = 1; amt <= amount; amt++) {
                int notTake = dp[amt];
                int take = Integer.MAX_VALUE;
                if (coins[i - 1] <= amt) {
                    take = dp[amt - coins[i - 1]];
                    if (take != Integer.MAX_VALUE) {
                        take = 1 + take;
                    }
                }

                dp[amt] = Math.min(take, notTake);
            }
        }


        int ans = dp[amount];
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private int f(int i, int amt, int[] coins, Integer[][] dp) {
        if (amt == 0) {
            return 0;
        }
        if (i == -1) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][amt] != null) return dp[i][amt];

        int notTake = f(i - 1, amt, coins, dp);
        int take = Integer.MAX_VALUE;
        if (coins[i] <= amt) {
            take = f(i, amt - coins[i], coins, dp);
            if (take != Integer.MAX_VALUE) {
                take = 1 + take;
            }
        }

        return dp[i][amt] = Math.min(take, notTake);
    }
}