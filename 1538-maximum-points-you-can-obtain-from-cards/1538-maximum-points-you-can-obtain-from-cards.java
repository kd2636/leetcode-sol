class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = max + cardPoints[i];
        }
        lSum = max;
        int j = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[j];
            System.out.println("--- " + rSum);
            j--;
            max = Math.max(max, lSum + rSum);
        }

        return max;
        
    }
}