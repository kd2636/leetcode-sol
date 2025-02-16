class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int lastA = -1, lastB = -1, lastC = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                lastA = i;
            } else if (s.charAt(i) == 'b') {
                lastB = i;
            } else {
                lastC = i;
            }
            count = count + Math.min(lastA, Math.min(lastB, lastC)) + 1;
        }
        return count;
    }
}