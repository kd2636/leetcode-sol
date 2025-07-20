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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxLinearPathSum(root, max);
        return max[0];        
    }

    // like height
    private int maxLinearPathSum(TreeNode root, int[] max) {
        if (root == null) return 0;

        int leftMaxSum = maxLinearPathSum(root.left, max);
        int rightMaxSum = maxLinearPathSum(root.right, max);

        // as numbers can be negative
        if (leftMaxSum < 0) leftMaxSum = 0;
        if (rightMaxSum < 0) rightMaxSum = 0;
        max[0] = Math.max(max[0], root.val + leftMaxSum + rightMaxSum);

        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
}