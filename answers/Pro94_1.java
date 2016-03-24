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
    public void inorder(TreeNode curNode, List<Integer> result){
        if(curNode != null){
            inorder(curNode.left, result);
            result.add(curNode.val);
            inorder(curNode.right, result);
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        
        return result;
    }
}