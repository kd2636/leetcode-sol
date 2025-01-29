class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 1;
        for (int i = coins[0]; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int np = dp[i - 1][j];

                int p = 0;
                if (coins[i] <= j) {
                    p = dp[i][j - coins[i]];
                }

                dp[i][j] = p + np;
            }
        }
        return dp[n - 1][amount];
    }

}