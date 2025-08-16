class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        // reversing graph
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                g.get(node).add(i);
            }
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int adj : g.get(i)) {
                indegree[adj]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);

            for (int adj : g.get(node)) {
                indegree[adj]--;
                if (indegree[adj] == 0) q.add(adj);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}