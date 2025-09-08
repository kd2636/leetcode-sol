class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];
        return helper(0, s, dict, dp);
    }

    private boolean helper(int i, String s, Set<String> dict, Boolean[] dp) {
        if (i == s.length()) return true;

        if (dp[i] != null) return dp[i];
        String word = "";
        for (int j = i; j < s.length(); j++) {
            word = word + s.charAt(j);
            if (dict.contains(word)) {
                dp[i] = helper(j + 1, s, dict, dp);
                if (dp[i]) {
                    return true;
                }
            }
        }
        return dp[i] = false;
    }
}