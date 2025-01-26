class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        // dp[i][j] -> stores minimum falling sum from 1st row till (i, j)
        Integer[][] dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, f(n - 1, i, matrix, dp));
        }
        return min;
    }

    // f(i, j) -> returns minimum path sum from ist row to (i, j)
    private int f(int i, int j, int[][] matrix, Integer[][] dp) {
        if (j < 0 || j > matrix.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (i == 0) {
            return matrix[i][j];
        }
        if (dp[i][j] != null) return dp[i][j];
        return dp[i][j] = matrix[i][j] + Math.min(f(i - 1, j - 1, matrix, dp), Math.min(f(i - 1, j, matrix, dp), f(i - 1, j + 1, matrix, dp)));
    }
}