class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // binary search


        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            int binaryIndex = Collections.binarySearch(temp, nums[i]);
            if (binaryIndex < 0) {
                binaryIndex = -binaryIndex - 1;
                if (binaryIndex == temp.size()) {
                    temp.add(nums[i]);
                } else {
                    temp.set(binaryIndex, nums[i]);
                }                
            } 
        }

        return temp.size();

    }

}