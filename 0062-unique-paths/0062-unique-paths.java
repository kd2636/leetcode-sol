class Solution {
    public int uniquePaths(int m, int n) {
        //dp[i][j] -> returns count of unique paths from (0,0) to (i,j)
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else{
                    int up = prev[j];
                    int left = 0;
                    if (j - 1 >= 0) {
                        left = curr[j - 1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[n - 1];
        
    }
}