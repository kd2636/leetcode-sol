class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        Integer[][] dp = new Integer[l1][l2];
        return lcs(text1, text1.length() - 1, text2, text2.length() - 1, dp);
    }

    private int lcs(String s1, int i1, String s2, int i2, Integer[][] dp) {
        if (i1 == -1 || i2 == -1) {
            return 0;
        }

        if (dp[i1][i2] != null) return dp[i1][i2];

        int lcs = 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            lcs = 1 + lcs(s1, i1 - 1, s2, i2 - 1, dp);
        } else {
            lcs = Math.max(lcs(s1, i1 - 1, s2, i2, dp), lcs(s1, i1, s2, i2 - 1, dp));
        }
        return dp[i1][i2] = lcs;
    }
}