class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int n = s.length();

        while (r < n) {
            if (map.getOrDefault(s.charAt(r), -1) >= l) {
                l = map.getOrDefault(s.charAt(r), -1) + 1;
            }

            map.put(s.charAt(r), r);
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }

        return maxLength;

        
    }
}