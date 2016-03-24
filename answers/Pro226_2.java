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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            TreeNode swap = curNode.left;
            curNode.left = curNode.right;
            curNode.right = swap;
            
            if (curNode.left != null){
                stack.push(curNode.left);
            }
            if (curNode.right != null){
                stack.push(curNode.right);
            }
        }
        
        return root;
    }
}