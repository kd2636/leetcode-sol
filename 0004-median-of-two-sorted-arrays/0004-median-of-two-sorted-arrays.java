class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int e1Index = n / 2 - 1;
        int e2Index = n / 2;
        int index = 0;
        int e1 = 0;
        int e2 = 0;


        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if(index == e1Index) {
                    e1 = nums1[i];
                } else if (index == e2Index) {
                    e2 = nums1[i];
                }
                i++;
            } else {
                if(index == e1Index) {
                    e1 = nums2[j];
                } else if (index == e2Index) {
                    e2 = nums2[j];
                }
                j++;
            }
            index++;
        }


        while (i < n1) {
            if(index == e1Index) {
                e1 = nums1[i];
            } else if (index == e2Index) {
                e2 = nums1[i];
            }
            i++;
            index++;
        }

        while (j < n2) {
            if(index == e1Index) {
                e1 = nums2[j];
            } else if (index == e2Index) {
                e2 = nums2[j];
            }
            j++;
            index++;
        }

        if (n % 2 == 0) return (double)((e1 + e2) / 2.0);
        return (double)e2;
    }
}