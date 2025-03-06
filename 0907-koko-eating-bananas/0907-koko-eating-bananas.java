class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = (int)1e9;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossibleToFinish(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    private boolean isPossibleToFinish(int[] piles, double k, int h) {
        
        long count = 0;
        for (int n : piles) {
            count = count + (int)(Math.ceil(n / k));
            if (count > h) {
                return false;
            }
        }

        if (count <= h) {
            return true;
        } else {
            return false;
        }
    }
}