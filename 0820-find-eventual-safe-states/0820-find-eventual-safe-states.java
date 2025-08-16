class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> pathVisited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, graph, visited, pathVisited, ans);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    private boolean dfs(int node, int[][] graph, Set<Integer> visited, Set<Integer> pathVisited, List<Integer> ans) {
        visited.add(node);
        pathVisited.add(node);

        for (int adj : graph[node]) {
            if (!visited.contains(adj)) {
                boolean isCyclic = dfs(adj, graph, visited, pathVisited, ans);
                if (isCyclic) return true;
            } else if (pathVisited.contains(adj)) {
                return true;
            }
        }

        ans.add(node);
        pathVisited.remove(node);
        return false;
    }
}