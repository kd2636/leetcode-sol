class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i1 = 1; i1 <= l1; i1++) {
            for (int i2 = 1; i2 <= l2; i2++) {
                int lcs = 0;
                if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
                    lcs = 1 + dp[i1 - 1][i2 - 1];
                } else {
                    lcs = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                }
                dp[i1][i2] = lcs;
            }
        }
        return dp[l1][l2];
    }
}