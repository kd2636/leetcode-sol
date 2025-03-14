class Solution {
    public int findKthPositive(int[] arr, int k) {
        // [2, 3, 4, 7, 11]
        // [1, 2, 3, 4, 5]


        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        // a[high] + (k - missing at high)
        // a[high] + (k - (a[high] - (high + 1)))
        // a[high] + (k - a[high] + high + 1)
        // k + high + 1;

        return high + 1 + k;


    }
}