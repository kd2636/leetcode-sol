class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            if (num == 1) count1++;
            if (num == 2) count2++;
        }

        int i = 0;

        while (count1 > 0 || count2 > 0 || count0 > 0) {
            if (count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else if (count2 > 0) {
                nums[i] = 2;
                count2--;
            }
            i++;
        }
    }
}