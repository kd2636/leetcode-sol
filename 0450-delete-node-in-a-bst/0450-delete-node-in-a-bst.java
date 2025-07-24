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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            return helper(root);
        }

        TreeNode ptr = root;

        while (ptr != null) {
            if (key < ptr.val) {
                if (ptr.left != null && ptr.left.val == key) {
                    ptr.left = helper(ptr.left);
                    break;
                } else {
                    ptr = ptr.left;
                }
            } else {
                if (ptr.right != null && ptr.right.val == key) {
                    ptr.right = helper(ptr.right);
                    break;
                } else {
                    ptr = ptr.right;
                }
            }
        }

        return root;
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        TreeNode leftMax = root.left;
        while(leftMax.right != null) {
            leftMax = leftMax.right;
        }
        leftMax.right = root.right;
        return root.left;
    }


}