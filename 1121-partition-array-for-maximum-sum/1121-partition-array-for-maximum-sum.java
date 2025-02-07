class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            int maxNumber = arr[i];
            for (int j = i; j < (i + k) && j < arr.length; j++) {
                maxNumber = Math.max(maxNumber, arr[j]);
                int cost = (maxNumber * (j + 1 - i)) + dp[j + 1];
                max = Math.max(max, cost);
            }
            dp[i] = max;
        }

        return dp[0];
    }

}