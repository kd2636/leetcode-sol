class Solution {

    /**
     * 2
     * 3 4
     * 6 5 7
     * 8 9 10 11
     *   
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] -> stores minimum path sum from (i, j) to last row;
        Integer[][] dp = new Integer[n][n];

        // base case initialization
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int d = dp[i + 1][j];
                int dr = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(d, dr);
            }
        }
        return dp[0][0];
    }

    // f(i, j) -> return min path sum from (i, j) to last row
    private int f(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != null) return dp[i][j];
        int d = f(i + 1, j, triangle, dp);
        int dr = f(i + 1, j + 1, triangle, dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(d, dr);
    }
}