class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] histogram = new int[n];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j] = histogram[j] + 1; 
                } else {
                    histogram[j] = 0;
                }
            }
            int area = getMaxRectHist(histogram);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int getMaxRectHist(int[] nums) {
        int n = nums.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int ele = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? - 1 : stack.peek();
                int area = nums[ele] * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int ele = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? - 1 : stack.peek();
            int area = nums[ele] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}