class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if (find(board, word, isVisited, 0, i, j) == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, String word, boolean[][] isVisited, int i, int r, int c) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        if (isVisited[r][c] == true) return false;

        isVisited[r][c] = true;
        if (find(board, word, isVisited, i + 1, r - 1, c) == true) return true;
        if (find(board, word, isVisited, i + 1, r + 1, c) == true) return true;
        if (find(board, word, isVisited, i + 1, r, c - 1) == true) return true;
        if (find(board, word, isVisited, i + 1, r, c + 1) == true) return true;
        isVisited[r][c] = false;

        return false;
    }
}