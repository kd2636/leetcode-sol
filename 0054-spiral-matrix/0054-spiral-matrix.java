class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int min = Math.min(m, n);

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < Math.ceil(min / 2.0); i++) {
            // right
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }

            // down
            for (int j = top + 1; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }

            if (top < bottom) {
                // left
                for (int j = right - 1; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
            }
            
            if (left < right) {
                // up
                for (int j = bottom - 1; j > top; j--) {
                    ans.add(matrix[j][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return ans;
    }
}