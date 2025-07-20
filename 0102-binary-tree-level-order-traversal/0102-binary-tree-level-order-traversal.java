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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderHelper(root, 0, ans);
        return ans;
    }

    private void levelOrderHelper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;

        if (ans.size() == level) ans.add(new ArrayList<>());

        // add root to ans
        ans.get(level).add(root.val);

        levelOrderHelper(root.left, level + 1, ans);
        levelOrderHelper(root.right, level + 1, ans);

    }
}