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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        List<TreeNode> level = new ArrayList<>();
        if (root != null) level.add(root);

        int isStraight = 1;
        while(!level.isEmpty()) {
            addToAns(ans, level, isStraight);
            List<TreeNode> nextLevel = new ArrayList<>();

            for (int i = 0; i < level.size(); i++) {
                if (level.get(i).left != null) {
                    nextLevel.add(level.get(i).left);
                }
                if (level.get(i).right != null) {
                    nextLevel.add(level.get(i).right);
                }
            }

            level = nextLevel;
            isStraight = isStraight * -1;
        }

        return ans;
    }

    private void addToAns(List<List<Integer>> ans, List<TreeNode> level, int isStraight) {
        if (isStraight == 1) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                temp.add(level.get(i).val);
            }
            ans.add(temp);
        } else {
            //reverse and add
            List<Integer> reverse = new ArrayList<>();
            for (int i = level.size() - 1; i >= 0; i--) {
                reverse.add(level.get(i).val);
            }
            ans.add(reverse);
        }
    }
}