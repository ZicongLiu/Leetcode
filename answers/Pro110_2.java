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
        
        int lMax = maxDepth(curNode.left);
        if (lMax == -1){
            return -1;
        }
        int rMax = maxDepth(curNode.right);
        if (rMax == -1){
            return -1;
        }
        
        return (Math.abs(lMax - rMax) > 1)  ? -1 : Math.max(lMax, rMax) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        
        return  maxDepth(root) != -1;
    }
}