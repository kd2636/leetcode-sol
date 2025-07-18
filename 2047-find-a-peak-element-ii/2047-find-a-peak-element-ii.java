class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int maxEleRow = getMaxEleRow(mat, mid);

            int curr = mat[maxEleRow][mid];

            int left = mid - 1 >= 0 ? mat[maxEleRow][mid - 1] : -1;

            int right = mid + 1 < n ? mat[maxEleRow][mid + 1] : -1;


            if (curr > left && curr > right) {
                return new int[]{maxEleRow, mid};
            }  

            if (left > curr) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }


    private int getMaxEleRow(int[][] mat, int col) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i  < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}