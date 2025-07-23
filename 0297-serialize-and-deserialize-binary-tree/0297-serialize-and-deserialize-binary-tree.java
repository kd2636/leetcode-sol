/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
            return ;
        }

        sb.append(root.val);
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preorder = data.split(",");
        int[] index = new int[1];
        index[0] = 0;
        return build(preorder, index);
    }

    private TreeNode build(String[] preorder, int[] index) {
        if (index[0] >= preorder.length) return null;

        if (preorder[index[0]].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(preorder[index[0]]));
        index[0]++;
        root.left = build(preorder, index);
        index[0]++;
        root.right = build(preorder, index);

        return root;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));