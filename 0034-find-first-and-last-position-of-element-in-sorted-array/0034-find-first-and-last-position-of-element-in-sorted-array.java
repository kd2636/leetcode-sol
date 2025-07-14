class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int lb = lowerBound(nums, target);
        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }
        int ub = upperBound(nums, target);
        ans[0] = lb;
        ans[1] = ub - 1;
        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}