class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[i][amt] -> stores min number of coins required to get amt from 0 to i.
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 0;

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int np = dp[i - 1][j];

                int p = -1;
                if (coins[i] <= j) {
                    p = 1 + dp[i][j - coins[i]];
                }

                int ans = 0;
                if (np == -1 && (p == 0 || p == -1)) {
                    ans = -1;
                } else if (np == -1) {
                    ans = p;
                } else if (p == 0 || p == -1) {
                    ans = np;
                } else {
                    ans = Math.min(p, np);
                }

                dp[i][j] = ans;
            }
        }

        return dp[n - 1][amount];
    }

}