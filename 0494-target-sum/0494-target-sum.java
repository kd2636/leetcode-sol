class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        Map<String, Integer> dp = new HashMap<>();
        return f(n - 1, target, nums, dp);
    }

    // f(i, target) -> return number if expressions from 0 to i with sum = target
    private int f(int i, int target, int[] nums, Map<String, Integer> dp) {
        if (i == 0) {
            if ((target - nums[0] == 0) || (target + nums[0] == 0)) {
                if (nums[0] == 0) return 2;
                return 1;
            }
            return 0;
        }
        String key = i + "*" + target;
        if (dp.get(key) != null) return dp.get(key);
        int ans = f(i - 1, target - nums[i], nums, dp) + f(i - 1, target + nums[i], nums, dp);
        dp.put(key, ans);
        return ans;
    }
}