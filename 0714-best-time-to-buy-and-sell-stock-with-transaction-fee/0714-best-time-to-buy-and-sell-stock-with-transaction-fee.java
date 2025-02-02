class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] next = new int[2];
        int[] curr = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    int a = -prices[i] - fee + next[1];
                    int b = next[0];
                    curr[j] = Math.max(a, b);
                } else {
                    int a = prices[i] + next[0];
                    int b = next[1];
                    curr[j] = Math.max(a, b);
                }
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[0];
    }

}