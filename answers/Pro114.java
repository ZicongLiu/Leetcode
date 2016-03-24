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
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        
        if (root.left != null){
            TreeNode formerLeft = root.left;
            TreeNode formerRight = root.right;
            root.left = null;
            root.right = formerLeft;
            
            TreeNode rightMost = formerLeft;
            while(rightMost.right != null){
                rightMost = rightMost.right;
            }
            rightMost.right = formerRight;
        }
        flatten(root.right);
    }
}