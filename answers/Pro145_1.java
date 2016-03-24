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
    public void postorderRecursion(TreeNode curNode, List<Integer> result){
        if (curNode != null){
            postorderRecursion(curNode.left, result);
            postorderRecursion(curNode.right, result);
            result.add(curNode.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        postorderRecursion(root, result);
        
        return result;
    }
}