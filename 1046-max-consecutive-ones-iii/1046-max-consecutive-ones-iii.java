class Solution {
    public int longestOnes(int[] nums, int k) {
        // all you need is to find the longest subarrays with max 0s upto k

        int l = 0;
        int r = 0;
        int zeroes = 0;
        int n = nums.length;
        int maxLength = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeroes++;
            }

            if (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            }

            if (zeroes <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }

            r++;
        }

        return maxLength;
    }
}