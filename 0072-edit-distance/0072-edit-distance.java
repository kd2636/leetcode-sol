class Solution {
    public int minDistance(String word1, String word2) {
        // f(i, j) -> return min operation to convert s1 (0 to i) to s2 (0 to j)
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int minOperations = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minOperations = Math.min(dp[i - 1][j - 1], 1 + dp[i - 1][j]);
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    minOperations = Math.min(insert, Math.min(delete, replace));
                }
                dp[i][j] = minOperations;
            }
        }


        return dp[l1][l2];
    }

}