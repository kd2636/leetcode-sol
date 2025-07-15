class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = arr[0] - 1;
        int ans = 0;
        if (k <= missingCount) {
            return k;
        }
        int prevMissCount = missingCount;
        for (int i = 1; i < arr.length; i++) {
            missingCount = missingCount + (arr[i] - arr[i - 1] - 1);
            if (k <= missingCount) {
                return arr[i - 1] + (k - prevMissCount);
            }
            prevMissCount = missingCount;
        }

        return arr[arr.length - 1] + (k - prevMissCount);
    }
}