class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> prefixSumToCountMap = new HashMap<>();

        int ans = 0;
        int sum = 0;
        prefixSumToCountMap.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            if (prefixSumToCountMap.containsKey(sum - k)) {
                ans = ans + prefixSumToCountMap.get(sum - k);
            }
            prefixSumToCountMap.put(sum, prefixSumToCountMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}