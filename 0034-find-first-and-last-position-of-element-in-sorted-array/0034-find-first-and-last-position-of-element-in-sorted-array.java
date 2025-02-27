class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        
        if (lb == ub) {
            return new int[]{-1, -1};
        } else {
            return new int[]{lb, ub - 1};
        }
    }

    private int lowerBound(int[] nums, int x) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int upperBound(int[] nums, int x) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}