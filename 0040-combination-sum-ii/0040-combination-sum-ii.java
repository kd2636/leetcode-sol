class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, 0, target, list, ans);
        return ans;
    }

    private void helper(int[] nums, int i, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target < 0) return ;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        }

        for (int k = i; k < nums.length; k++) {
            if (k == i || nums[k] != nums[k - 1]) {
                list.add(nums[k]);
                helper(nums, k + 1, target - nums[k], list, ans);
                list.removeLast();
            }
        }

    }
}