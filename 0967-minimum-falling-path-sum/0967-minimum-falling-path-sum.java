class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // dp[i][j] -> stores minimum falling sum from 1st row till (i, j)
        Integer[] dp = new Integer[n];
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }
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
            }
        }
        

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}