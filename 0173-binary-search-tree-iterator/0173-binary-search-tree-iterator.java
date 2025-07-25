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


    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
    }
    
    public int next() {
        TreeNode top = stack.pop();
        TreeNode temp = top.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */