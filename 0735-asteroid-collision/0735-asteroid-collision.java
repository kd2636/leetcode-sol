class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int n = asteroids.length;
        for (int i = 1; i < n; i++) {
            boolean toInsert = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                int top = stack.peek();
                int top_abs = Math.abs(top);
                int curr_abs = Math.abs(asteroids[i]);
                if (curr_abs > top_abs) {
                    stack.pop();
                } else if (curr_abs == top_abs) {
                    stack.pop();
                    toInsert = false;
                    break;
                } else {
                    toInsert = false;
                    break;
                }
            }
            if (toInsert) {
                stack.push(asteroids[i]);
            }
        }

        int[] ans = new int[stack.size()];
        int i = ans.length - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }
}