class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[] dp = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[i] = i / coins[0];
            else dp[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int np = dp[j];

                int p = -1;
                if (coins[i] <= j) {
                    p = dp[j - coins[i]];
                }

                int ans = 0;
                if (np == -1 && p == -1) {
                    ans = -1;
                } else if (np == -1) {
                    ans = 1 + p;
                } else if (p == -1) {
                    ans = np;
                } else {
                    ans = Math.min(1 + p, np);
                }

                dp[j] = ans;
            }
        }

        return dp[amount];
    }

}