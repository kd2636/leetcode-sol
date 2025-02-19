class Solution {
    public void sortColors(int[] nums) {
        // DNF (Dutch National Flag) sort


        // 0 -> 0...low-1
        // 1 -> low...mid-1
        // unsorted -> mid....high
        // 2 -> high+1...n-1

        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;


        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }

    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}