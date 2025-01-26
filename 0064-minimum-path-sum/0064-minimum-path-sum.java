class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] -> stores minimum path sum from (0, 0) to (i, j)
        Integer[][] dp = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        up = dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}