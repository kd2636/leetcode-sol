class Solution {
    public void rotate(int[][] matrix) {
        int n  = matrix.length;

        int l = 0, r = n - 1, t = 0, b = n - 1;

        for (int i = 0; i < (n / 2); i++) {
            for (int j = 0; j < (r - l); j++) {
                int temp = matrix[t][l + j];
                matrix[t][l + j] = matrix[b - j][l];
                matrix[b - j][l] = matrix[b][r - j];
                matrix[b][r - j] = matrix[t + j][r];
                matrix[t + j][r] = temp;
            }
            l = l + 1;
            r = r - 1;
            t = t + 1;
            b = b - 1;
        }
    }
}