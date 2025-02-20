class Solution {
    public int majorityElement(int[] nums) {
        // Moore's voting algo
        int count = 0;
        int ele = -1;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                ele = nums[i];
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }
}