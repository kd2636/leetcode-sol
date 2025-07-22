/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        List<Pair> level = new ArrayList<>();
        if (root != null) {
            level.add(new Pair(root, 0));
        }
        int max = Integer.MIN_VALUE;
        
        while (!level.isEmpty()) {
            List<Pair> nextLevel = new ArrayList<>();
            int minIndex = level.get(0).index;
            int maxIndex = level.get(level.size() - 1).index;
            int diff = maxIndex - minIndex + 1;
            max = Math.max(max, diff);
            for (int i = 0; i < level.size(); i++) {
                TreeNode curr = level.get(i).node;
                int currIndex = level.get(i).index;
                if (curr.left != null) {
                    nextLevel.add(new Pair(curr.left, (currIndex - minIndex) * 2));
                }
                if (curr.right != null) {
                    nextLevel.add(new Pair(curr.right, ((currIndex - minIndex) * 2) + 1));
                }
            }

            level = nextLevel;
        }

        return max;
    }
}