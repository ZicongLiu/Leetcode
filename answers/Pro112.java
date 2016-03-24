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
    public boolean findPath(TreeNode curNode, int remainingSum){
        if (curNode == null){
            return false;
        }
        remainingSum -= curNode.val;
        if (curNode.left == null && curNode.right == null){
            if (remainingSum == 0)
                return true;
            else 
                return false;
        }
        return findPath(curNode.left, remainingSum)
         || findPath(curNode.right, remainingSum);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        return findPath(root, sum);
    }
}