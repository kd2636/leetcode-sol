class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int n = isConnected.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                ans++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.remove();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[node][j] == 1 && !visited.contains(j)) {
                            q.add(j);
                            visited.add(j);
                        }
                    }
                }
            }
        }

        return ans;
    }
}