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
    public List<TreeNode> generateTree(int start, int end){
        List<TreeNode> uniqueTrees = new ArrayList<TreeNode>();
        if (start > end){
            uniqueTrees.add(null);
        }
        for (int rootVal = start ; rootVal <= end ; rootVal ++){
            List<TreeNode> leftTrees = generateTree(start, rootVal - 1);
            List<TreeNode> rightTrees = generateTree(rootVal + 1 , end);
            for (TreeNode leftNode : leftTrees){
                for (TreeNode rightNode : rightTrees){
                    TreeNode rootNode = new TreeNode(rootVal);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    
                    uniqueTrees.add(rootNode);
                }
            }
        }
        return uniqueTrees;
    }
    public List<TreeNode> generateTrees(int n) {

        if (n == 0){
            return new ArrayList<TreeNode>();
        }
        return generateTree(1 , n);
    }
}