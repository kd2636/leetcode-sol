class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] numpad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, sb, ans, numpad);
        return ans;
    }

    private void helper(String digits, int i, StringBuilder sb, List<String> ans, String[] numpad) {
        if (i >= digits.length()) {
            ans.add(new String(sb));
            return;
        }

        int c = digits.charAt(i) - 48;
        String letters = numpad[c];
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            helper(digits, i + 1, sb, ans, numpad);
            sb.setLength(sb.length() - 1);
        }
    }
}