class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];


        for (int j = 1; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insertion = curr[j - 1];
                    int replacement = prev[j - 1];
                    int deletion = prev[j];

                    curr[j] = 1 + Math.min(insertion, Math.min(replacement, deletion));
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }

}