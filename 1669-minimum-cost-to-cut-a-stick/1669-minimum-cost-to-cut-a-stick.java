class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < cuts.length; i++) {
            c.add(cuts[i]);
        }
        c.add(0);
        c.add(n);
        Collections.sort(c);

        int[][] dp = new int[c.size()][c.size()];

        for (int i = c.size() - 2; i >= 1; i--) {
            for (int j = i; j <= c.size() - 2; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = dp[i][k - 1];
                    int right = dp[k + 1][j];
                    int total = left + right + (c.get(j + 1) - c.get(i - 1));
                    min = Math.min(min, total);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c.size() - 2];
    }

    private int f(int i, int j, List<Integer> cuts, Integer[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int left = f(i, k - 1, cuts, dp);
            int right = f(k + 1, j, cuts, dp);
            int total = left + right + (cuts.get(j + 1) - cuts.get(i - 1));
            min = Math.min(min, total);
        }
        return dp[i][j] = min;
    }
}