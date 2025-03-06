class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = findMax(bloomDay);
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low == max + 1 ? -1 : low;
    }


    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int consecutiveCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (day >= bloomDay[i]) {
                consecutiveCount++;
                if (consecutiveCount == k) {
                    count++;
                    consecutiveCount = 0;
                }
            } else {
                consecutiveCount = 0;
            }
        }
        if (count >= m) {
            return true;
        } else {
            return false;
        }
    }

    private int findMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int num : bloomDay) {
            max = Math.max(max, num);
        }
        return max;
    }
}