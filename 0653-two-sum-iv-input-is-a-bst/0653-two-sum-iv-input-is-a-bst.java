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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);

        int start = 0;
        int end = inorder.size() - 1;
        while (start < end) {
            if (inorder.get(start) + inorder.get(end) == k) return true;
            if (inorder.get(start) + inorder.get(end) < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return ;

        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }
}