class Solution {
    static class Tuple {
        int a;
        int b;
        int d;

        Tuple(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        int[][] vis = new int[m][n];

        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Tuple(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Tuple tuple = q.remove();
            int r = tuple.a;
            int c = tuple.b;
            int d = tuple.d;

            ans[r][c] = d;

            int[] drow = new int[]{-1, 0, 1, 0};
            int[] dcol = new int[]{0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    q.add(new Tuple(nr, nc, d + 1));
                }
            }
        }

        return ans;
        
    }

}