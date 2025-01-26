class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // dp[i][j] -> stores minimum falling sum from 1st row till (i, j)
        Integer[][] dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = Integer.MAX_VALUE;
                int topRight = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    topLeft = dp[i - 1][j - 1];
                }
                if (j + 1 < n) {
                    topRight = dp[i - 1][j + 1];
                }
                dp[i][j] = matrix[i][j] + Math.min(topLeft, Math.min(dp[i - 1][j], topRight));
            }
        }
        

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}