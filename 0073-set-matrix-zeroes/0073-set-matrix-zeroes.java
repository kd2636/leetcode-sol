class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFrstRowHavingZero = false;
        boolean isFrstColHavingZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isFrstRowHavingZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFrstColHavingZero = true;
                break;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // iterating 1st row
        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {
                makeColZero(matrix, col);
            }
        }

        // iterating 1st col
        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {
                makeRowZero(matrix, row);
            }
        }

        if (isFrstRowHavingZero) {
            makeRowZero(matrix, 0);
        }

        if (isFrstColHavingZero) {
            makeColZero(matrix, 0);
        }
    }

    private void makeRowZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void makeColZero(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

}