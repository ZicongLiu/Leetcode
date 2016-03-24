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
    int sum = 0;
    public void traverseSum(TreeNode curNode , int curSum){
        if (curNode == null){
            return;
        }
        curSum  = curSum * 10 + curNode.val;
        if (curNode.left == null && curNode.right == null){
            sum += curSum;
        
            return;
        }
        
        traverseSum(curNode.left, curSum);
        traverseSum(curNode.right , curSum);
    }
    
    public int sumNumbers(TreeNode root) {
        traverseSum(root, 0);
        return sum;
    }
}