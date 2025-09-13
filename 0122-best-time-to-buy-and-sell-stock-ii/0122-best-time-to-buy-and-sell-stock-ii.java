class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] next = new int[2];
        
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    curr[j] = Math.max(next[0], -prices[i] + next[1]);
                } else {
                    curr[j] = Math.max(next[1], prices[i] + next[0]);
                }
            }
            next = curr;
        }
        return next[0];
    }
}