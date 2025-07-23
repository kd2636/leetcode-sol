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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd) return null;

        int root = postorder[postEnd];
        int inorderIndex = inorderMap.get(root);
        int leftSize = inorderIndex - inStart;
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = build(inorder, inStart, inorderIndex - 1, postorder, postStart, postStart + leftSize - 1, inorderMap);
        rootNode.right = build(inorder, inorderIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1, inorderMap);
        return rootNode;
    }
}