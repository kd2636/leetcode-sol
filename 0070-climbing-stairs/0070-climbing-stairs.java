class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        return f(n, dp);
    }

    // f(i) -> 0 to i

    private int f(int i, Integer[] dp) {
        if (i < 0) return 0;
        if (i == 0) return 1;

        if (dp[i] != null) return dp[i];

        return dp[i] = f(i - 1, dp) + f(i - 2, dp);
    }
}