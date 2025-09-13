class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= l2; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else {
                break;
            } 
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[l1][l2];
    }
}