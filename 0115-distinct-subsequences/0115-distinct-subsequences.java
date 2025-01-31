class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        //dp[i][j] -> stores ans for s(0 to i) and t(0 to j).
        int[] dp = new int[m + 1];
        
        dp[0] = 1;

        // for (int j = 0; j <=m; j++) {
        //     dp[0][j] = 0;
        // }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }

        return dp[m];
        
    }

}