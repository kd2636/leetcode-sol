class Solution {

    static class Pair {
        int a; 
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }


        int ans = -1;
        while (!q.isEmpty()) {
            int n1 = q.size();
            ans++;
            for (int i = 0; i < n1; i++) {
                Pair pair = q.remove();
                int x = pair.a;
                int y = pair.b;

                //left
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    q.add(new Pair(x, y - 1));
                } 

                //right
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    q.add(new Pair(x, y + 1));
                } 

                //down
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    q.add(new Pair(x + 1, y));
                } 

                //up
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    q.add(new Pair(x - 1, y));
                } 

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans == -1 ? 0 : ans;
    }
}