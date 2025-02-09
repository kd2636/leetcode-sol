class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int ele = stack.pop();
                if (heights[ele] > heights[i]) {
                    // got nse
                    int nse = i;
                    int pse = stack.isEmpty() ? -1 : stack.peek();
                    int area = heights[ele] * (nse - pse - 1);
                    maxArea = Math.max(maxArea, area);
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int ele = stack.pop();
            int nse =  n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int area = heights[ele] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    
}