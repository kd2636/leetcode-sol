class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countEqualOrLess(nums, k) - countEqualOrLess(nums, k - 1);
    }


    private int countEqualOrLess(int[] nums, int k) {
        if (k == 0) return 0;
        int n = nums.length;
        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                if (map.get(nums[l]) == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                }
                l++;
            }

            count = count + (r - l + 1);
            r++;
        }
        return count;
    }
}