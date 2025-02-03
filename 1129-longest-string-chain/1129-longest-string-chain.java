class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int n = words.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isDiffByOne(words[j], words[i]) && (dp[j] + 1 > dp[i])) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    private boolean isDiffByOne(String small, String big) {
        //System.out.println("small - " + small + ", big = " + big);
        if (small.length() + 1 != big.length()) {
            //System.out.println("returning false");
            return false;
        }

        int i = 0; // for small
        int j = 0; // for big
        int diff = 0;
        while (i < small.length() && j < big.length()) {
            if (small.charAt(i) == big.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                diff++;
            }
        }
        //System.out.println("returning - " + (diff <= 1));
        return diff <= 1;
    }
}