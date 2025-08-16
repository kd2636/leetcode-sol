class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        int[] indegree = new int[n];
        int[] topo = new int[n];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int adj : graph.get(i)) {
                indegree[adj]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.remove();
            topo[index++] = node;

            for (int adj : graph.get(node)) {
                indegree[adj]--;
                if (indegree[adj] == 0) q.add(adj);
            }
        }

        if (index == n) return topo;
        return new int[0];
    }
}