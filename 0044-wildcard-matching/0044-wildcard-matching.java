class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return f(n - 1, m - 1, s, p, dp);
    }

    private boolean f(int i, int j, String s, String p, Boolean[][] dp) {
        //System.out.println("i - " + i + ",  j - " + j);

        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {
            if (p.charAt(j) == '*') return f(i, j - 1, s, p, dp);
            else return false;
        }
        

        if (dp[i][j] != null) return dp[i][j];

        if ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '?') {
            return dp[i][j] = f(i - 1, j - 1, s, p, dp);
        }

        if (p.charAt(j) == '*') {
            return dp[i][j] = f(i, j - 1, s, p, dp) || (f(i - 1, j, s, p, dp) || f(i - 1, j - 1, s, p, dp));
        }

        //System.out.println("should be reaching here directly");
        return dp[i][j] = false;
    }
}