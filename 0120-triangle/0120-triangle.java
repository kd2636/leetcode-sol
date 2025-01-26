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
        Integer[][] dp = new Integer[n][n];
        return f(0, 0, triangle, dp);
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