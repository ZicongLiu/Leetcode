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
    public TreeNode buildTree(int[] inorder, int startInorder, int endInorder,
     int[] postorder, int startPost, int endPost){
        if (startInorder > endInorder){
            return null;
        }
        
        int split = postorder[endPost];
        
        TreeNode rootNode = new TreeNode(split);
        if (startInorder == endInorder){
            return rootNode;
        }
        
        int splitIdx = -1;
        for (int idx = startInorder; idx <= endInorder; idx ++){
            if (inorder[idx] == split){
                splitIdx = idx;
                break;
            }
        }
        
        rootNode.left = buildTree(inorder , startInorder, splitIdx - 1 ,
         postorder , startPost , startPost + splitIdx - 1 - startInorder);
        rootNode.right = buildTree(inorder, splitIdx + 1 , endInorder ,
         postorder , startPost + splitIdx - startInorder , endPost - 1);
        
        return rootNode;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
         postorder , 0 , postorder.length - 1);
    }
}