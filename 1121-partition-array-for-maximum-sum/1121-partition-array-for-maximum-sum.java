class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        return f(0, k, arr, dp);
    }

    private int f(int i, int k, int[] arr, Integer[] dp) {
        if (i == arr.length) return 0;

        if (dp[i] != null) return dp[i];

        int max = 0;
        int maxNumber = arr[i];
        for (int j = i; j < (i + k) && j < arr.length; j++) {
            maxNumber = Math.max(maxNumber, arr[j]);
            int cost = (maxNumber * (j + 1 - i)) + f(j + 1, k, arr, dp);
            max = Math.max(max, cost);
        }
        return dp[i] = max;
    }
}