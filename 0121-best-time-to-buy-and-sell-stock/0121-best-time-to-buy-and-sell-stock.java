class Solution {
    public int maxProfit(int[] prices) {
        // f(i, j) -> return max profit from i to n - 1 with prev action as j
        // j as 0 : not bought anything
        // j as 1 : bought a stock, can sell only
        int n = prices.length;
        int[] postfix = new int[n];
        postfix[n - 1] = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = Math.max(prices[i], postfix[i + 1]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, postfix[i] - prices[i]);
        }
        return maxProfit;
    }
}