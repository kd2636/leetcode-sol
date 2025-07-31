class Solution {

    static class Node {
        Node[] children = new Node[2];
    }


    public int findMaximumXOR(int[] nums) {
        Node root = new Node();

        for (int num : nums) {
            addNum(root, num);
        }

        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, getMaxXOR(root, num));
        }

        return ans;
    }

    private void addNum(Node root, int num) {
        Node ptr = root;
        for (int i = 31; i>= 0; i--) {
            int bit = (num >> i) & 1;
            if (ptr.children[bit] == null) {
                ptr.children[bit] = new Node();
            }
            ptr = ptr.children[bit];
        }
    }

    private int getMaxXOR(Node root, int num) {
        int xor = 0;
        Node ptr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (ptr.children[1 - bit] != null) {
                xor = xor | (1 << i); // setting ith bit
                ptr = ptr.children[1 - bit];
            } else {
                ptr = ptr.children[bit];
            }
        }
        return xor;
    }

}