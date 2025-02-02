class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[3];
        int[] curr = new int[3];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    int a = -prices[i] + next[1];
                    int b = next[0];
                    curr[j] = Math.max(a, b);
                } else if (j == 1) {
                    int a = prices[i] + next[2];
                    int b = next[1];
                    curr[j] = Math.max(a, b);
                } else {
                    curr[j] = next[0];
                }
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[0];
    }

}