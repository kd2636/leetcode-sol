class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 0) {
                        int a = -prices[i] + next[1][k];
                        int b = next[0][k];
                        curr[j][k] = Math.max(a, b);
                    } else {
                        int a = prices[i] + next[0][k - 1];
                        int b = next[1][k];
                        curr[j][k] = Math.max(a, b);
                    }
                }
            }
            int[][] temp = next;
            next = curr;
            curr = temp;
        }

        return next[0][2];
        
    }
}