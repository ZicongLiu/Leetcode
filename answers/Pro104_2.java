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
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        int depth = 0;
        queue.offer(root);
        
        while (!queue.isEmpty()){
            depth ++;
            List<TreeNode> levelNodeList = new ArrayList<TreeNode>();
            
            while (!queue.isEmpty()){
                levelNodeList.add(queue.poll());
            }
            
            for (TreeNode levelNode : levelNodeList){
                if (levelNode.left != null){
                    queue.offer(levelNode.left);
                }
                if (levelNode.right != null){
                    queue.offer(levelNode.right);
                }
            }
        }
        
        return depth;
    }
}