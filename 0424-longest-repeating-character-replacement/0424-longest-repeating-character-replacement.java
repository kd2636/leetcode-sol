class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxF = 0;
        int maxLength = 0;
        int l = 0, r = 0;

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            while (r - l + 1 - maxF > k) {
                //System.out.println(l);
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
                for (Character c : map.keySet()) {
                    maxF = Math.max(maxF, map.get(c));
                }
            }

            if (r - l + 1 - maxF <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
        return maxLength;
    }
}