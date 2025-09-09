class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return f(m - 1, n - 1, dp);
    }

    private int f(int r, int c, Integer[][] dp) {
        if (r == 0) {
            return 1;
        }
        if (c == 0) {
            return 1;
        }
        if (dp[r][c] != null) return dp[r][c];

        return dp[r][c] = f(r - 1, c, dp) + f (r, c - 1, dp);
    }
}