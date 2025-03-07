class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = findMax(nums);
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isLessThanThreshold(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean isLessThanThreshold(int[] nums, double divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + (int)Math.ceil(num / divisor);
        }
        return sum <= threshold;
    }
}