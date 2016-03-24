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
    int maxSum = Integer.MIN_VALUE;
    public int findMax(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        maxSum = Math.max(maxSum , root.val + leftMax + rightMax);
        int maxPath = Math.max(leftMax, rightMax) + root.val;
        
        return maxPath > 0 ? maxPath : 0;
    }
    public int maxPathSum(TreeNode root) {
        findMax(root);
        
        return maxSum;
    }
}