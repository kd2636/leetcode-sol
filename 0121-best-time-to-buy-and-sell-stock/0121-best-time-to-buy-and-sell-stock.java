class Solution {
    public int maxProfit(int[] prices) {
        // f(i, j) -> return max profit from i to n - 1 with prev action as j
        // j as 0 : not bought anything
        // j as 1 : bought a stock, can sell only
        int n = prices.length;
        int maxProfit = 0;
        int minSoFar = prices[0];

        for (int i = 0; i < n; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }

        return maxProfit;
    }
}