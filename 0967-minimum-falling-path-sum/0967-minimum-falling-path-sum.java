class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // dp[i][j] -> stores minimum falling sum from 1st row till (i, j)
        Integer[] dp = new Integer[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
            min = Math.min(min, dp[i]);
        }

        if (n == 1) return min;
        else min = Integer.MAX_VALUE;
        
        int temp = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = Integer.MAX_VALUE;
                int topRight = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    topLeft = temp;
                }
                if (j + 1 < n) {
                    topRight = dp[j + 1];
                }
                temp = dp[j];
                dp[j] = matrix[i][j] + Math.min(topLeft, Math.min(dp[j], topRight));
                if (i == n - 1) {
                    min = Math.min(min, dp[j]);
                }
            }
        }
        return min;
    }
}