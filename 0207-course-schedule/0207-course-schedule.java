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
        
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : graph.get(i)) {
                indegree[node]++;
            }
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.remove();
            count++;
            for (int adj : graph.get(node)) {
                indegree[adj]--;
                if (indegree[adj] == 0) q.add(adj);
            }
        }

        if (count < n) return true;
        return false;

    }
}