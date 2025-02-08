class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int mod = (int)(1e9 + 7);
        
        // next smaller element index
        int[] nse = getNSE(arr);

        // previous smaller or equal element index
        int[] psee = getPSEE(arr);

        for (int i = 0; i < n; i++) {
            long right = nse[i] - i;
            long left = i - psee[i];
            long total = (left * right * arr[i]) % mod;
            sum = (sum + total) % mod;
        }

        return (int)sum;
    }

    private int[] getNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }


    private int[] getPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return psee;
    }
}