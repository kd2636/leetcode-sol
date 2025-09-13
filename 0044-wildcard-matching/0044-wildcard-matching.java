class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        Boolean[][] dp = new Boolean[l1][l2];
        return f(s, l1 - 1, p, l2 - 1, dp);
    }

    private boolean f(String s, int i, String p, int j, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = f(s, i - 1, p, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            return dp[i][j] = f(s, i - 1, p, j, dp) || f(s, i - 1, p, j - 1, dp) || f (s, i, p, j - 1, dp);
        } else {
            return dp[i][j] = false;
        }
    }
}