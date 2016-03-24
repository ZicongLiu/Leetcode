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
    public int getLeftHeight(TreeNode curNode){
        if (curNode == null){
            return 0;
        }
        int height = 0;
        while (curNode != null){
            height ++;
            curNode = curNode.left;
        }
        return height;
    }
    public int getRightHeight(TreeNode curNode){
        if (curNode == null){
            return 0;
        }
        int height = 0;
        while (curNode != null){
            height ++;
            curNode = curNode.right;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null){
            return 0;
        }
        if (getLeftHeight(root.left) == getRightHeight(root.right)){
            return (1 << getLeftHeight(root)) - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}