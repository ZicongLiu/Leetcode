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
    public boolean validBST(TreeNode root, Integer min, Integer max){
        
        if (root == null){
            return true;
        }
        if (min != null){
            if (root.val <= min){
                return false;
            }
        }
        if (max != null){
            if (root.val >= max){
                return false;
            }
        }
        
        return validBST(root.left, min, root.val)
         && validBST(root.right, root.val, max);
    }
    
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
       
    }
}