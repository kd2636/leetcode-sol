class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] next = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int cap = 1; cap <= (2 * k); cap++) {
                if (cap % 2 == 0) {
                    int a = -prices[i] + next[cap - 1];
                    int b = next[cap];
                    curr[cap] = Math.max(a, b);
                } else {
                    int a = prices[i] + next[cap - 1];
                    int b = next[cap];
                    curr[cap] = Math.max(a, b);
                }
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[2 * k];
    }

}