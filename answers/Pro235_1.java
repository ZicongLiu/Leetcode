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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode curNode = root;
        int minVal = Math.min(p.val, q.val);
        int maxVal = Math.max(p.val, q.val);
        
        while (!(curNode.val >= minVal && curNode.val <= maxVal)){
            if (curNode.val > maxVal){
                curNode = curNode.left;
            }
            if (curNode.val < minVal){
                curNode = curNode.right;
            }
        }
        
        return curNode;
    }
}