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
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int exc = robExcludeRoot(root);
        int inc = robIncludeRoot(root);
        return Math.max(exc, inc);
    }

    private int robExcludeRoot(TreeNode root) {
        if (root == null){
            return 0;
        }
        return rob(root.left) + rob(root.right);
    }
    
    private int robIncludeRoot(TreeNode root){
        if (root == null){
            return 0;
        }
        return root.val + robExcludeRoot(root.left) + robExcludeRoot(root.right);
    }
}