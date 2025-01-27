class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int k = sum / 2;
        return isSubsetSumTarget(nums, k);
    }

    private boolean isSubsetSumTarget(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] -> store if there is a subset with sum j from 0 to i
        boolean[] prev = new boolean[k + 1];
        boolean[] curr = new boolean[k + 1];
        if (nums[0] <= k) {
            prev[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                // not take
                if (prev[target]) {
                    curr[target] = true;
                } else if (nums[i] <= target && prev[target - nums[i]]) {
                    curr[target] = prev[target - nums[i]];
                } else {
                    curr[target] = false;
                }
            }
            boolean[] temp = null;
            temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[k];
        
    }
}