class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        return f(m - 1, n - 1, grid, dp); 
    }
    // f(i, j) -> return minimum path sum from (0, 0) to (i, j)
    private int f(int i, int j, int[][] grid, Integer[][] dp) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (dp[i][j] != null) return dp[i][j];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            up = f(i - 1, j, grid, dp);
        }
        if (j - 1 >= 0) {
            left = f(i, j - 1, grid, dp);
        }

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}