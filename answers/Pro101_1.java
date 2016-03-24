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
    public boolean checkSymmetric(TreeNode node1 , TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        else if (node1 != null && node2 != null && node1.val == node2.val){
            return checkSymmetric(node1.left, node2.right)
             && checkSymmetric(node1.right, node2.left);
        }
        else{
            return false;
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }
}