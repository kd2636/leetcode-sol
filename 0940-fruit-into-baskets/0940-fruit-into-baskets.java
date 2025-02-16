class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int dc = 0;
        int maxLength = 0;

        while (r < fruits.length) {
            if (map.getOrDefault(fruits[r], 0) == 0) {
                dc++;
            }

            while (dc > 2) {
                if (map.getOrDefault(fruits[l], 0) == 1) {
                    map.put(fruits[l], 0);
                    dc--;
                } else {
                    map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
                }
                l++;
            }

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }

        return maxLength;
    }
}