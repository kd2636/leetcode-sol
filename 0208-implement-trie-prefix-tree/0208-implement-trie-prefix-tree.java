
class Trie {

    Node root;

    static class Node {
        char val;
        Node[] children;
        boolean isLeaf;

        Node(char val, boolean isLeaf) {
            this.val = val;
            children = new Node[26];
            this.isLeaf = isLeaf;
        }
    }

    public Trie() {
        root = new Node('*', false);
    }
    
    public void insert(String word) {
        Node ptr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (ptr.children[index] == null) {
                ptr.children[index] = new Node(c, false);
            }
            ptr = ptr.children[index];
        }
        ptr.isLeaf = true;
    }
    
    public boolean search(String word) {
        Node ptr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (ptr.children[index] == null) {
                return false;
            }
            ptr = ptr.children[index];
        }
        return ptr.isLeaf;
        
    }
    
    public boolean startsWith(String prefix) {
        Node ptr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (ptr.children[index] == null) {
                return false;
            }
            ptr = ptr.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */