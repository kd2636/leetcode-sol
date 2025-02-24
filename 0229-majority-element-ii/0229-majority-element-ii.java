class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // based on Moore voiting algo
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        

        for (int num : nums) {
            if (count1 == 0 && num != ele2) {
                count1 = 1;
                ele1 = num;
            } else if (count2 == 0 && num != ele1) {
                count2 = 1;
                ele2 = num;
            } else if (num == ele1) {
                count1++;
            } else if (num == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        if (isMajority(nums, ele1)) {
            ans.add(ele1);
        }
        if (isMajority(nums, ele2)) {
            ans.add(ele2);
        }
        return ans;

    }

    private boolean isMajority(int[] nums, int ele) {
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (num == ele) count++;
        }

        return count > n / 3;
    }
}