class Solution {
    public int minDistance(String word1, String word2) {
        // f(i, j) -> return min operation to convert s1 (0 to i) to s2 (0 to j)
        int l1 = word1.length();
        int l2 = word2.length();
        Integer[][] dp = new Integer[l1][l2];
        return f(word1, l1 - 1, word2, l2 - 1, dp);
    }

    private int f(String s1, int i, String s2, int j, Integer[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != null) return dp[i][j];

        int minOperations = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            minOperations = Math.min(f(s1, i - 1, s2, j - 1, dp), 1 + f(s1, i - 1, s2, j, dp));
        } else {
            int insert = 1 + f(s1, i, s2, j - 1, dp);
            int delete = 1 + f(s1, i - 1, s2, j, dp);
            int replace = 1 + f(s1, i - 1, s2, j - 1, dp);
            minOperations = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j] = minOperations;
    }
}