class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = getTotalWeight(weights);

        int low = 1;
        int high = totalWeight;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int getTotalWeight(int[] weights) {
        int sum = 0;
        for (int num : weights) {
            sum = sum + num;
        }
        return sum;
    }

    private boolean isPossible(int[] weights, int cap, int days) {
        int count = 0;
        int currWt = 0;
        for (int weight : weights) {
            if (weight > cap) return false;
            currWt = currWt + weight;
            if (currWt > cap) {
                currWt = weight;
                count++;
            }
        }

        if (currWt > 0) count++;

        return count <= days;
    }
}