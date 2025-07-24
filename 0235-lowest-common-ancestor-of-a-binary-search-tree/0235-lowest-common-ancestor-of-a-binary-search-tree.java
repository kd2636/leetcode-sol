/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null) return null;

        TreeNode lca = null;

        while (root != null) {
            if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
                lca = root;
                break;
            } 

            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return lca;
    }
}