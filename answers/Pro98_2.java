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
    public void inorderTraverse(TreeNode root , List<Integer> traversal){
        if (root == null){
            return;
        }
        
        inorderTraverse(root.left, traversal);
        traversal.add(root.val);
        inorderTraverse(root.right, traversal);
    }
    
    public boolean isValidBST(TreeNode root) {
       List<Integer> traversal = new ArrayList<Integer>();
       inorderTraverse(root , traversal);
       for (int idx = 1 ; idx < traversal.size() ; idx ++){
           if (traversal.get(idx) <= traversal.get(idx - 1)){
               return false;
           }
       }
       
       return true;
    }
}