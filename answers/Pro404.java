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
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root, false);
        return sum;
    }
    
    private void traverse(TreeNode root, boolean isLeft){
        if (root == null){
            return;
        }
        if (isLeft && root.left == null && root.right == null){
            sum += root.val;
        }
        else{
            traverse(root.left, true);
            traverse(root.right, false);
        }
    }
}