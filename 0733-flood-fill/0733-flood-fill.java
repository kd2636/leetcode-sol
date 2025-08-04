class Solution {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];

        if (oc == color) return image;

        int m = image.length;
        int n = image[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            Pair pair = q.remove();

            // up, right, down, left
            int[] drow = new int[]{-1, 0, 1, 0};
            int[] dcol = new int[]{0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nr = pair.a + drow[i];
                int nc = pair.b + dcol[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oc) {
                    q.add(new Pair(nr, nc));
                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }
}