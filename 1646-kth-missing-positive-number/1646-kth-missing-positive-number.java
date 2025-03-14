class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> missing = new ArrayList<>();
        int count = 0;
        int index = 0;

        for (int i = 1; i <= 2000; i++) {
            if (index < arr.length && arr[index] == i) {
                index++;
            } else {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }

        return -1;
    }
}