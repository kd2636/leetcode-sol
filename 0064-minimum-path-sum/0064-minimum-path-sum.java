class Solution {
    public int minPathSum(int[][] grid) {
        // f(i, j) -> 0 to i, j
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] dp = new Integer[m][n];

        return f(grid, m - 1, n - 1, dp);
    }

    private int f(int[][] grid, int r, int c, Integer[][] dp) {
        if (r == 0 && c == 0) {
            return grid[r][c];
        }

        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[r][c] != null) return dp[r][c];

        return dp[r][c] = grid[r][c] + Math.min(f(grid, r - 1, c, dp), f(grid, r, c - 1, dp));
    }
}