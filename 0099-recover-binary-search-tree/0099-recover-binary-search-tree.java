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
    TreeNode a = null;
    TreeNode middle = null;
    TreeNode b = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        inorder(root);

        if (b == null) {
            //swap a and middle
            swap(a, middle);
        } else {
            // swap a and b
            swap(a, b);
        }
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return ;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (a == null) {
                a = prev;
                middle = root;
            } else {
                b = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
}