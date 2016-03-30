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
    public int maxDepth(TreeNode curNode){
        if (curNode == null){
            return 0;
        }
        
        return Math.max(maxDepth(curNode.left), maxDepth(curNode.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        
        return  (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1)
         && isBalanced(root.left) && isBalanced(root.right);
    }
}