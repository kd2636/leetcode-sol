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
class BSTIterator {

    int index;
    List<Integer> inorder;

    public BSTIterator(TreeNode root) {
        index = -1;
        inorder = new ArrayList<>();

        inorder(root, inorder);
        
    }
    
    public int next() {
        index++;
        return inorder.get(index); 
    }
    
    public boolean hasNext() {
        if ((index + 1) == inorder.size()) return false;
        return true;
    }

    private void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */