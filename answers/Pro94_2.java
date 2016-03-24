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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> traversalStack = new Stack<TreeNode>();
        
        TreeNode curNode = root;
        while (curNode != null){
            traversalStack.push(curNode);
            curNode = curNode.left;
        }
        while (!traversalStack.isEmpty()){
            curNode = traversalStack.pop();
            result.add(curNode.val);
            
            TreeNode addNode = curNode.right;
            
            while (addNode != null){
                traversalStack.push(addNode);
                addNode = addNode.left;
            }
        }
        
        return result;
    }
}