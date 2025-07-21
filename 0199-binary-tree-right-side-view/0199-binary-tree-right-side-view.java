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
    public List<Integer> rightSideView(TreeNode root) {
      Map<Integer, Integer> map = new HashMap<>();
      preorder(root, map, 0);

      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < map.size(); i++) {
        ans.add(map.get(i));
      }

      return ans;
    }


    private void preorder(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) return ;

        map.put(level, root.val);
        preorder(root.left, map, level + 1);
        preorder(root.right, map, level + 1);
    }
}