/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();

        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        childParentMap.put(root, null);
        helper(root, childParentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> marked = new HashSet<>();
        queue.add(target);
        marked.add(target);
        int count = 0;
        
        while(count < k) {
            count++;
            int q = queue.size();
            //System.out.println("iteration for queue size - " + q);
            for (int i = 0; i < q; i++) {
                TreeNode curr = queue.remove();
                //System.out.println("removed from queue - " + curr.val);
                if (curr.left != null && !marked.contains(curr.left)) {
                    marked.add(curr.left);
                    queue.add(curr.left);
                }
                if (curr.right != null && !marked.contains(curr.right)) {
                    marked.add(curr.right);
                    queue.add(curr.right);
                }
                TreeNode parent = childParentMap.get(curr);
                // System.out.println("child - " + curr.val);
                // System.out.println("parent - " + parent.val);
                if (parent != null && !marked.contains(parent)) {
                    marked.add(parent);
                    queue.add(parent);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            ans.add(queue.remove().val);
        }
        return ans;
    }

    private void helper(TreeNode root, Map<TreeNode, TreeNode> childParentMap) {
        if (root == null) return ;

        if (root.left != null) {
            childParentMap.put(root.left, root);
        }
        if (root.right != null) {
            childParentMap.put(root.right, root);
        }
        helper(root.left, childParentMap);
        helper(root.right, childParentMap);

    }



}