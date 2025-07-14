class Solution {
    public int search(int[] nums, int target) {
        int beg = 0;
        int last = nums.length - 1;
        while (beg <= last) {
            int mid = (beg + last) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                last = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }
}