class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        // firt and last row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, vis);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i, vis);
            }
        }

        //first and last col
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, vis);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, vis);
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int[][] vis) {
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = 1;

        int[] drow = new int[]{-1, 0, 1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && vis[nr][nc] == 0) {
                dfs(board, nr, nc, vis);

            }
        }

    }
}