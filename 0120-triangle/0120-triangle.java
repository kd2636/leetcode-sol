class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //f (r, c) : r,c to last row
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return f(triangle, 0, 0, dp);
    }

    private int f(List<List<Integer>> triangle, int r, int c, Integer[][] dp) {
        if (r == triangle.size() - 1) {
            return triangle.get(r).get(c);
        }

        if (dp[r][c] != null) return dp[r][c];

        int op1 = f(triangle, r + 1, c, dp);
        int op2 = f(triangle, r + 1, c + 1, dp);

        return dp[r][c] = triangle.get(r).get(c) + Math.min(op1, op2);
    }
}