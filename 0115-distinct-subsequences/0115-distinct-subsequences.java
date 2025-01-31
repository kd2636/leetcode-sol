class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        //dp[i][j] -> stores ans for s(0 to i) and t(0 to j).
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        prev[0] = 1;
        curr[0] = 1;

        // for (int j = 0; j <=m; j++) {
        //     dp[0][j] = 0;
        // }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
        
    }

}