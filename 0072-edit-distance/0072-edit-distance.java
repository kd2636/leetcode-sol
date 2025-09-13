class Solution {
    public int minDistance(String word1, String word2) {
        // f(i, j) -> return min operation to convert s1 (0 to i) to s2 (0 to j)
        int l1 = word1.length();
        int l2 = word2.length();
        int[] prev = new int[l2 + 1];

        for (int i = 0; i <= l2; i++) {
            prev[i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            int[] curr = new int[l2 + 1];
            curr[0] = i;
            for (int j = 1; j <= l2; j++) {
                int minOperations = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minOperations = prev[j - 1];
                } else {
                    int insert = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
                    minOperations = Math.min(insert, Math.min(delete, replace));
                }
                curr[j] = minOperations;
            }
            prev = curr;
        }


        return prev[l2];
    }

}