class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }


        }

        return ans;
    }
}