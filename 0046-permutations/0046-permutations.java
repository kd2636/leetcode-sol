class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        helper(nums, list, ans, taken);
        return ans;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] taken) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!taken[i]) {
                taken[i] = true;
                list.add(nums[i]);
                helper(nums, list, ans, taken);
                list.removeLast();
                taken[i] = false;
            }
        }
    }
}