class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return f(n - 1, amount, coins, dp);
    }

    // f(i, amt) -> returns min number of coins required to get amt from 0 to i.
    private int f(int i, int amount, int[] coins, Integer[][] dp) {
        if (i == 0) {
          if (amount == 0) return 0;
          if (amount % coins[0] == 0) return amount / coins[0];
          return -1;
        }

        if (dp[i][amount] != null) return dp[i][amount];

        // not pick coin[i]
        int np = f(i - 1, amount, coins, dp);
        

        // pick coin[i]
        int p = 0;
        if (coins[i] <= amount) {
            p = 1 + f(i, amount - coins[i], coins, dp);
        }

        int ans = 0;
        if (np == -1 && p == 0) {
            ans = -1;
        } else if (np == -1) {
            ans = p;
        } else if (p == 0) {
            ans = np;
        } else {
            ans = Math.min(p, np);
        }

        return dp[i][amount] = ans;
    }
}