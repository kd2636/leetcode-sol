class Solution {
    public long subArrayRanges(int[] nums) {
        long maxSubarraySum = getMaxSubarraySum(nums);
        long minSubarraySum = getMinSubarraySum(nums);

        return maxSubarraySum - minSubarraySum;
    }

    private long getMaxSubarraySum(int[] nums) {
        int n = nums.length;
        int[] nge = getNGE(nums);
        int[] pgee = getPGEE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long right = nge[i] - i;
            long left = i - pgee[i];
            long total = left * right * nums[i];
            sum = sum + total;
        }

        return sum;
    }

    private long getMinSubarraySum(int[] nums) {
        int n = nums.length;
        int[] nse = getNSE(nums);
        int[] psee = getPSEE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long right = nse[i] - i;
            long left = i - psee[i];
            long total = left * right * nums[i];
            sum = sum + total;
        }

        return sum;
    }

    private int[] getNGE(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nge;
    }

    private int[] getNSE(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    private int[] getPGEE(int[] nums) {
        int n = nums.length;
        int[] pgee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            pgee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pgee;
    }

    private int[] getPSEE(int[] nums) {
        int n = nums.length;
        int[] psee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return psee;
    }
}