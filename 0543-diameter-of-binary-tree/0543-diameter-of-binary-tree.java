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

    private int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max - 1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        max = Math.max(max, 1 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}