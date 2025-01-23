class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] left = new int[n - 1];
        int[] right = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != 0) right[i - 1] = nums[i];
            if (i != n - 1) left[i] = nums[i];
        }

        return Math.max(robHelper(left), robHelper(right));
    }

    // tabulation soln to solve house robber 1
    private int robHelper(int[] nums) {
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}