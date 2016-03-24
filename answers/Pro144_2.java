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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> traversalStack = new Stack<TreeNode>();
        traversalStack.push(root);
        while (!traversalStack.isEmpty()){
            TreeNode curNode = traversalStack.pop();
            
            result.add(curNode.val);
            
            if (curNode.right != null){
                traversalStack.push(curNode.right);
            }
            if (curNode.left != null){
                traversalStack.push(curNode.left);
            }
        }
        return result;
    }
}