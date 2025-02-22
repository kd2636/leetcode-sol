class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posI = 0;
        int negI = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negI] = nums[i];
                negI += 2;
            } else {
                ans[posI] = nums[i];
                posI += 2;
            }
        }

        return ans;
        
    }
}