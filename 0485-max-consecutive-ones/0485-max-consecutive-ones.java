class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        return max;
        
    }
}