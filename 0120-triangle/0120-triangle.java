class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //f (r, c) : r,c to last row
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n-1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int op1 = dp[i + 1][j];
                int op2 = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(op1, op2);
            }
        }
        return dp[0][0];
    }
    
}