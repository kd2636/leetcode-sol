class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        // firt and last row
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i, vis);
            }
            if (grid[m - 1][i] == 1) {
                dfs(grid, m - 1, i, vis);
            }
        }

        //first and last col
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, vis);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1, vis);
            }
        }
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }


        private void dfs(int[][] grid, int row, int col, int[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[row][col] = 1;

        int[] drow = new int[]{-1, 0, 1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                dfs(grid, nr, nc, vis);

            }
        }

    }
}