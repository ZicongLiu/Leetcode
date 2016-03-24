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
    List<TreeNode> inorderList = new ArrayList<TreeNode>();
    
    public void inorderTraverse(TreeNode curNode){
        if (curNode == null){
            return;
        }
        
        inorderTraverse(curNode.left);
        inorderList.add(curNode);
        inorderTraverse(curNode.right);
    }
    
    public void recoverTree(TreeNode root) {
        inorderTraverse(root); 
        
        boolean firstToFind = true;
        TreeNode mistakenNode1 = null, mistakenNode2 = null;
        
        for (int nodeIdx = 0 ; nodeIdx < inorderList.size() - 1 ; nodeIdx++){
            if (inorderList.get(nodeIdx).val >= inorderList.get(nodeIdx + 1).val){
                if (firstToFind){
                    mistakenNode1 = inorderList.get(nodeIdx);
                    mistakenNode2 = inorderList.get(nodeIdx + 1);
                    firstToFind = false;
                }else{
                    mistakenNode2 = inorderList.get(nodeIdx + 1);
                }
            }
        }
        
        // swap
        int swapVal = mistakenNode1.val;
        mistakenNode1.val = mistakenNode2.val;
        mistakenNode2.val = swapVal;
    }
}