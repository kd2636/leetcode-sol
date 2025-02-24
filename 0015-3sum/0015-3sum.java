class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // brute 
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                if (visited.contains(-(nums[j] + nums[i]))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-(nums[j] + nums[i]));
                    Collections.sort(list);
                    set.add(list);
                }
                visited.add(nums[j]);
            }
        }

        ans.addAll(set);
        return ans;
    }
}