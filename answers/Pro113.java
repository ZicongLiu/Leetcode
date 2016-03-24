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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public void findPath(TreeNode curNode, int remainingSum, List<Integer> curPath){
        if (curNode == null){
            return;
        }
        remainingSum -= curNode.val;
        curPath.add(curNode.val);
        
        if (curNode.left == null && curNode.right == null){
            if (remainingSum == 0){
                result.add(new ArrayList(curPath));
                return;
            }
            else{
                return;
            }
        }
        
        findPath(curNode.left, remainingSum, new ArrayList(curPath));
        findPath(curNode.right, remainingSum, new ArrayList(curPath));
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> curPath = new ArrayList<Integer>();
        findPath(root, sum, curPath);
        
        return result;    
    }
}