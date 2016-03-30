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
    
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null){
            return 0;
        }
        
        TreeNode curNode = root;
        while (curNode != null){
            int lHeight = getLeftHeight(curNode.left);
            int rHeight = getLeftHeight(curNode.right);
            
            if (lHeight > rHeight){
                // +1 means addding the root node
                count += ((1 << rHeight) - 1) + 1;
                curNode = curNode.left;
            }
            else {
                // lHeight == rHeight
                count += ((1 << lHeight) - 1) + 1;
                curNode = curNode.right;
            }
        }
        
        return count;
    }
}