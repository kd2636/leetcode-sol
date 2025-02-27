class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int i, int j) {
        if (i >= j) return 0;
        int count = 0;
        int mid = (i + j) / 2;
        count += mergeSort(nums, i, mid);
        count += mergeSort(nums, mid + 1, j);
        count += merge(nums, i, mid, mid + 1, j);
        return count;
    }

    private int merge(int[] nums, int i1, int j1, int i2, int j2) {
        int n1 = j1 - i1 + 1;
        int n2 = j2 - i2 + 1;

        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        int k = 0;
        for (int i = i1; i <= j1; i++) {
            temp1[k++] = nums[i]; 
        }
        k = 0;
        for (int i = i2; i <= j2; i++) {
            temp2[k++] = nums[i]; 
        }

        int l = 0, r = 0;
        int count = 0;

        while (l < n1 && r < n2) {
            if ((long)temp1[l] > (2 * (long)temp2[r])) {
                count = count + (n1 - l);
                r++;
            } else {
                l++;
            }
        }


        l = 0;
        r = 0;
        k = i1;
        while (l < n1 && r < n2) {
            if (temp1[l] <= temp2[r]) {
                nums[k++] = temp1[l];
                l++;
            } else {
                nums[k++] = temp2[r];
                r++;
            }
        }

        while (l < n1) nums[k++] = temp1[l++];

        while (r < n2) nums[k++] = temp2[r++];

        return count;
    }
}