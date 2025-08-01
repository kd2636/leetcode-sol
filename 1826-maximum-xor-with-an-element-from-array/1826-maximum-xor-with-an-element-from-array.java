class Solution {
    static class Node {
        Node[] children = new Node[2];

    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Node root = new Node();
        Arrays.sort(nums);
        List<List<Integer>> offlineQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            List<Integer> q = new ArrayList<>();
            q.add(query[0]); //xi
            q.add(query[1]); //mi
            q.add(i); //i
            offlineQueries.add(q);
        }
        Collections.sort(offlineQueries, (a, b) -> a.get(1) - b.get(1));

        int[] ans = new int[queries.length];
        int j = 0;
        for (int i = 0; i < offlineQueries.size(); i++) {
            List<Integer> q = offlineQueries.get(i);
            while (j < nums.length && nums[j] <= q.get(1)) {
                addNum(root, nums[j]);
                j++;
            }
            ans[q.get(2)] = getMaxXOR(root, q.get(0));
        }

        return ans;
    }

    private void addNum(Node root, int num) {
        Node ptr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (ptr.children[bit] == null) {
                ptr.children[bit] = new Node();
            }
            ptr = ptr.children[bit];
        }
    }

    private int getMaxXOR(Node root, int num) {
        Node ptr = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (ptr.children[1 - bit] != null) {
                xor = xor | (1 << i);
                ptr = ptr.children[1 - bit];
            } else if (ptr.children[bit] != null) {
                ptr = ptr.children[bit];
            } else {
                return -1;
            }
        }
        return xor;
    }
}