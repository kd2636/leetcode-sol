class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i; j++) {
                if (j < i - 1) {
                    row.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1));
                } else {
                    row.add(1);
                }
            }
            ans.add(row);
        }

        return ans;
    }
}