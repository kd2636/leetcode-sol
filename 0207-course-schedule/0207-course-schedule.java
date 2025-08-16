class Solution {

    // Cycle detection in directed graph - DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        if (hasCycle(graph)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean hasCycle(List<List<Integer>> graph) {
        int n = graph.size();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> pathVisited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                boolean isCyclic = dfs(i, graph, visited, pathVisited);
                if (isCyclic == true) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> graph, Set<Integer> visited, Set<Integer> pathVisited) {
        visited.add(node);
        pathVisited.add(node);

        for (int adj : graph.get(node)) {
            if (!visited.contains(adj)) {
                boolean isCyclic = dfs(adj, graph, visited, pathVisited);
                if (isCyclic == true) return true;
            } else if (pathVisited.contains(adj)) {
                return true;
            }
        }

        pathVisited.remove(node);
        return false;
    }
}