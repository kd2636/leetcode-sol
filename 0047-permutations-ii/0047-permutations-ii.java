class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        helper(nums, list, ans, taken);
        return ans;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] taken) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!taken[i] && !visited.contains(nums[i])) {
                visited.add(nums[i]);
                taken[i] = true;
                list.add(nums[i]);
                helper(nums, list, ans, taken);
                taken[i] = false;
                list.removeLast();
            }
        }
    }
}