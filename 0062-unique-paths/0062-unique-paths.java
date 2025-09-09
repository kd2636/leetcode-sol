class Solution {
    public int uniquePaths(int m, int n) {
        Integer[] prev = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            Integer[] curr = new Integer[n];
            curr[0] = 1;
            for (int j = 1; j < n; j++) {
                curr[j] = prev[j] + curr[j - 1];
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}