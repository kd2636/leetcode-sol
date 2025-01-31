class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        Integer[][] dp = new Integer[n][m];
        return f(n - 1, m - 1, word1, word2, dp);
    }

    // f(i, j) -> return min operation for coverting word1(0 to i) to word2(0 to j)
    private int f(int i, int j, String word1, String word2, Integer[][] dp) {

        if (j < 0 || i < 0) {
            return 1 + Math.max(i, j);
        }

        if (dp[i][j] != null) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = f(i - 1, j - 1, word1, word2, dp);
        } else {
            int insertion = f(i, j - 1, word1, word2, dp);
            int replacement = f(i - 1, j - 1, word1, word2, dp);
            int deletion = f(i - 1, j, word1, word2, dp);

            return dp[i][j] = 1 + Math.min(insertion, Math.min(replacement, deletion));
        }
    }
}