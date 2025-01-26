class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] dp = new Integer[m][n];
        return f(m - 1, n - 1, obstacleGrid, dp);
    }

    // f(i, j) -> return total unique ways from (0,0) to (i,j)
    private int f(int i, int j, int[][] grid, Integer[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != null) return dp[i][j];
        int up = f(i - 1, j, grid, dp);
        int left = f(i, j - 1, grid, dp);
        return dp[i][j] = up + left;
    }
}