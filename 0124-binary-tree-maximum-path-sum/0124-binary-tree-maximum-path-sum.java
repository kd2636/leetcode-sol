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
        int currSum = root.val;
        if (leftMaxSum > 0) currSum = currSum + leftMaxSum;
        if (rightMaxSum > 0) currSum = currSum + rightMaxSum;
        max[0] = Math.max(max[0], currSum);

        // as numbers can be negative
        int temp = Math.max(leftMaxSum, rightMaxSum);
        return root.val + (temp > 0 ? temp : 0);
    }
}