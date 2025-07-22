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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        int rootInorderIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootInorderIndex - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootInorderIndex - 1, inorderMap);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, rootInorderIndex + 1, inEnd, inorderMap);
        return root;
    }
}