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
    public TreeNode buildTree(int[] preorder, int startPre, int endPre,
     int[] inorder, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        int split = preorder[startPre];
        
        TreeNode rootNode = new TreeNode(split);
        if (startPre == endPre){
            return rootNode;
        }
        int idx = startIn;
        for (idx = startIn ; idx <= endIn ; idx ++){
            if (inorder[idx] == split){
                break;
            }
        }
        rootNode.left = buildTree(preorder, startPre + 1,
         startPre + idx - startIn , inorder, startIn , idx - 1);
        rootNode.right = buildTree(preorder ,
         startPre + idx - startIn + 1 ,endPre, inorder, idx + 1, endIn);
        
        return rootNode;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
         inorder , 0 , inorder.length - 1);    
    }
}