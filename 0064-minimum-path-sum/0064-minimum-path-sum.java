class Solution {
    public int minPathSum(int[][] grid) {
        // f(i, j) -> 0 to i, j
        int m = grid.length;
        int n = grid[0].length;

        Integer[] prev = new Integer[n];

        for (int i = 0; i < m; i++) {
            Integer[] curr = new Integer[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) {
                       up = prev[j]; 
                    }
                    if (j > 0) {
                        left = curr[j - 1];
                    }
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}