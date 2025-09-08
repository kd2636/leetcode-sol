class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        helper(s, 0, list, ans);
        return ans;
    }

    private void helper(String s, int i, List<String> list, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            sb.append(s.charAt(j));
            if (isPal(sb)) {
                list.add(new String(sb));
                helper(s, j + 1, list, ans);
                list.removeLast();
            }
        }
    }

    private boolean isPal(StringBuilder sb) {
        int l = sb.length();
        for (int i = 0 ; i < l / 2; i++) {
            if (sb.charAt(i) != sb.charAt(l - 1 - i)) return false;
        }
        return true;
    }
}