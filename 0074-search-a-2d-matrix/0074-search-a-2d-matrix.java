class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int i = getRow(mid, m, n);
            int j = getCol(mid, m, n);

            if (matrix[i][j] == target) return true;
            if (target < matrix[i][j]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    private int getRow(int index, int m, int n) {
        return index / n;
    }

    private int getCol(int index, int m, int n) {
        return index % n;
    }
}