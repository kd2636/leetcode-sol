class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;


        for (int i = n - 2; i >=0; i--) {
            if (nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }

        for (int i = n - 1; i > ind; i--) {
            if (ind != -1 && nums[i] > nums[ind]) {
                swap(nums, ind, i);
                break;
            }
        }

        reverse(nums, ind + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}