/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public void traverse(TreeNode root, int level){
        if (root == null){
            return;
        }
        if (level == result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        
        traverse(root.left , level + 1);
        traverse(root.right, level + 1);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        traverse(root, 0);
        
        return result;
    }
}