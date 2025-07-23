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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderInverse = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.right == null) {
                postorderInverse.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode temp = curr.right;
                while (temp.left != null & temp.left != curr) {
                    temp = temp.left;
                }
                if (temp.left == null) {
                    temp.left = curr;
                    postorderInverse.add(curr.val);
                    curr = curr.right;
                }

                if (temp.left == curr) {
                    temp.left = null;
                    curr = curr.left;
                }
            }
        }

        List<Integer> postorder = new ArrayList<>();
        for (int i = postorderInverse.size() - 1; i >= 0; i--) {
            postorder.add(postorderInverse.get(i));
        }
        return postorder;
    }
}