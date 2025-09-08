class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(nums, 0, list, ans);
        return ans;
    }

    private void helper(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));

        for (int j = i; j < nums.length; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                list.add(nums[j]);
                helper(nums, j + 1, list, ans);
                list.removeLast();
            }
        }
    }
}