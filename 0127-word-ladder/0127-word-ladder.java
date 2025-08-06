class Solution {
    static class Pair {
        String word;
        int level;

        Pair (String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair pair = q.remove();

            if (pair.word.equals(endWord)) {
                return pair.level;
            }

            String word = pair.word;

            for (int i = 0; i < word.length(); i++) {
                char[] wordArr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArr[i] = c;
                    String newWord = new String(wordArr);
                    if (set.contains(newWord)) {
                        q.add(new Pair(newWord, pair.level + 1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}