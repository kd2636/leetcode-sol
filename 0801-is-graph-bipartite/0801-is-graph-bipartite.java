class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                boolean isBiPartite = dfs(graph, i, color, 0);
                if (!isBiPartite) return false;
            }
        }

        return true;
        
    }


    private boolean dfs(int[][] graph, int source, int[] color, int ic) {
        color[source] = ic;
        for (int neighbour : graph[source]) {
            if (color[neighbour] == -1) {
                if (dfs(graph, neighbour, color, 1 - ic) == false) return false;
            } else if (color[neighbour] == ic) {
                return false;
            }
        }
        return true;
    }
}