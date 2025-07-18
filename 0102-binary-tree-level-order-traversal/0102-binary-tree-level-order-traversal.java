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

        if (root == null) return ans;
        
        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while(!level.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> newLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                list.add(level.get(i).val);

                if (level.get(i).left != null) {
                    newLevel.add(level.get(i).left);
                }
                if (level.get(i).right != null) {
                    newLevel.add(level.get(i).right);
                }
            }
            ans.add(list);
            level = newLevel;
        }

        return ans;
    }
}