class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int prev_i = 0; prev_i <= i; prev_i++) {
                int nt = next[prev_i];

                int t = 0;
                if (prev_i == 0 || nums[i] > nums[prev_i - 1]) {
                    t = 1 + next[i + 1];
                }

                curr[prev_i] = Math.max(nt, t);
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[0];
    }

}