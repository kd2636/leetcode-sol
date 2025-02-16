class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysEqualOrLess(nums, k) - numberOfSubarraysEqualOrLess(nums, k - 1);
    }

    private int numberOfSubarraysEqualOrLess(int[] nums, int k) {
        //if (k <= 0) return 0;

        int n = nums.length;
        int oddCount = 0, l = 0, r = 0, count = 0;

        while (r < n) {
            if (nums[r] % 2 != 0) oddCount++;

            while(oddCount > k) {
                if (nums[l] % 2 != 0) oddCount--;
                l++;
            }

            count = count + (r - l + 1);
            r++;
        } 
        return count;
    }
}