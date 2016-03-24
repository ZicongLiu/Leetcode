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
    public void preorder(TreeNode curNode, List<Integer> result){
        if (curNode != null){
            result.add(curNode.val);
            preorder(curNode.left, result);
            preorder(curNode.right , result);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        
        return result;
    }
}