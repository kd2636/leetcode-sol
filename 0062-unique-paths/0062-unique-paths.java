class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return f(m - 1, n - 1, dp);
        
    }
    // f(i, j) -> returns count of unique paths from (0,0) to (i,j)
    private int f(int i, int j, Integer[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        } else if (i < 0 || j < 0) {
            return 0;
        } else {
            if (dp[i][j] != null) return dp[i][j];
            int up = f(i - 1, j, dp);
            int left = f(i, j - 1, dp);
            return dp[i][j] = up + left;
        }
    }
}