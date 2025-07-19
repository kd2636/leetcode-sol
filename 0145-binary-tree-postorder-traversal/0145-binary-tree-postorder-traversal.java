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
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        List<Integer> ans = new ArrayList<>();

        if (root != null)
            s1.push(root); 

        while (!s1.isEmpty()) {
            TreeNode top = s1.pop();
            if (top.left != null) s1.push(top.left);
            if (top.right != null) s1.push(top.right);
            
            s2.push(top.val);
        }

        while(!s2.isEmpty()) {
            ans.add(s2.pop());
        }

        return ans;
    }
}