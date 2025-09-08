class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(1, k, n, list, ans);
        return ans;
    }

    private void helper(int i, int k, int n, List<Integer> list, List<List<Integer>> ans) {

        if (i > 9) {
            if (k == 0 && n == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (k < 0) return ;
        if (n < 0) return ;
        if (k == 0 && n != 0) return ;


        //pick
        list.add(i);
        helper(i + 1, k - 1, n - i, list, ans);
        list.removeLast();

        //not pick
        helper(i + 1, k, n, list, ans);
    }
}