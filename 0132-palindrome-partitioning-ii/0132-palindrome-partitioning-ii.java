class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];

        boolean[][] pdp = palindromeDpTable(s);

        for (int i = s.length() - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int k = i + 1; k <= s.length(); k++) {
                if (isPalindrome(i, k, pdp)) {
                    min = Math.min(min, 1 + dp[k]);
                }
            }
            dp[i] = min;
        }

        return dp[0] - 1;
    }

    private boolean isPalindrome(int i, int k, boolean[][] dp) {
        return dp[i][k - 1];
    }

    private boolean[][] palindromeDpTable(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if(j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
                else if (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp;
    }
}