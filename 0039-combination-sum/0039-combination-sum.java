class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(candidates, 0, 0, target, ans, list);
        return ans;
    }

    private void helper(int[] nums, int i, int sum, int target, List<List<Integer>> ans, List<Integer> list) {
        if (sum > target) {
            return ;
        }

        if (i == nums.length) {
            if (sum == target) {
                ans.add(new ArrayList<>(list));
            }
            return ;
        }

        // pick
        list.add(nums[i]);
        helper(nums, i, sum + nums[i], target, ans, list);
        list.remove(list.size() - 1);

        // not pick
        helper(nums, i + 1, sum, target, ans, list);
    }
}