class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        Integer[][] dp = new Integer[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            min = Math.min(min, f(matrix, 0, i, dp));
        }
        return min;
    }

    // f(r, c) : r,c to last
    private int f(int[][] matrix, int r, int c, Integer[][] dp) {
        if (r == matrix.length - 1) {
            return matrix[r][c];
        }

        if (dp[r][c] != null ) return dp[r][c];


        int left = Integer.MAX_VALUE;
        int center = f(matrix, r + 1, c, dp);
        int right = Integer.MAX_VALUE;

        if (c > 0) {
            left = f(matrix, r + 1, c - 1, dp);
        }
        if (c < matrix.length - 1) {
            right = f(matrix, r + 1, c + 1, dp);
        }

        return dp[r][c] = matrix[r][c] + Math.min(left, Math.min(center, right));
    }
}