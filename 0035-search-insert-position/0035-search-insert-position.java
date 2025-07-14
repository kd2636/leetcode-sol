class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int lb = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                lb = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return lb == -1 ? nums.length : lb;
    }
}