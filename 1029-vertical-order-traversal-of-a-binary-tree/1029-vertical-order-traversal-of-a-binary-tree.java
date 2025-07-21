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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();

        preorder(root, map, 0, 0);

        // convert map to ans
        int vLevelCount = map.size();
        List<List<Integer>> ans = new ArrayList<>(vLevelCount);

        List<Integer> vlevels = new ArrayList<>(map.keySet());
        Collections.sort(vlevels);
        for (int i = 0; i < vlevels.size(); i++) {
            List<Integer> levelList = new ArrayList<>();
            Map<Integer, List<Integer>> levelMap = map.get(vlevels.get(i));
            List<Integer> levels = new ArrayList<>(levelMap.keySet());
            Collections.sort(levels);
            for (int j = 0; j < levels.size(); j++) {
                int l = levels.get(j);
                Collections.sort(levelMap.get(l));
                levelList.addAll(levelMap.get(l));
            }
            ans.add(levelList);
        }
        return ans;

    }

    private void preorder(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map, int vlevel, int level) {
        if (root == null) return ;

        // add root to map
        Map<Integer, List<Integer>> levelMap = map.getOrDefault(vlevel, new HashMap<>());
        List<Integer> rowList = levelMap.getOrDefault(level, new ArrayList<>());
        rowList.add(root.val);
        levelMap.put(level, rowList);
        map.put(vlevel, levelMap);

        preorder(root.left, map, vlevel - 1, level + 1);
        preorder(root.right, map, vlevel + 1, level + 1);
    }
}