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
    public int countNodes(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode root) {
        if (root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if (lh == rh) {
            return (int)(Math.pow(2, lh) - 1);
        } else {
            return 1 + count(root.left) + count(root.right);
        }
    }

    private int leftHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + leftHeight(root.left);
    }

    private int rightHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + rightHeight(root.right);
    }
}