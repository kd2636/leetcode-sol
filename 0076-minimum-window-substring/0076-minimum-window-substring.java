class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, sIndex = -1, minLength = Integer.MAX_VALUE, count = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (r < n) {
            if (map.getOrDefault(s.charAt(r), 0) >= 1) {
                count++;
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);


            while (count == t.length()) {
                // shrink the window
                if ((r - l + 1) < minLength) {
                    minLength = r - l + 1;
                    sIndex = l;
                }
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                if (map.get(s.charAt(l)) > 0) {
                    count--;
                }
                l++;
            }

            r++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
    }
}