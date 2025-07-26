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
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        inorder(root, inorder);

        TreeNode a = null;
        TreeNode middle = null;
        TreeNode b = null;



        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1).val > inorder.get(i).val) {
                if (a == null) {
                    a = inorder.get(i - 1);
                    middle = inorder.get(i);
                } else {
                    b = inorder.get(i);
                }
            }
        }

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

    private void inorder(TreeNode root, List<TreeNode> inorder) {
        if (root == null) return ;

        inorder(root.left, inorder);
        inorder.add(root);
        inorder(root.right, inorder);
    }
}