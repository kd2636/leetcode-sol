class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        int max = 1;
        int max_i = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                max_i = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (true) {
            res.add(nums[max_i]);
            if (hash[max_i] == max_i) break;
            max_i = hash[max_i];
        }
        return res;
    }
}