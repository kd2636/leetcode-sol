class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > (num.charAt(i) - '0')) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i) - '0');
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        if (i == sb.length()) return "0";

        return sb.substring(i).toString();

    }
}