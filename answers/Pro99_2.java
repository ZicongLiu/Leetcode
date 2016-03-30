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
    TreeNode mistakenNode1 = null, mistakenNode2 = null;
    TreeNode prev = null;
    boolean firstFound = true;
    public void recoverTree(TreeNode root) {
        TreeNode curNode = root;
        while (curNode != null){
            if (curNode.left == null){
                // print
                if (prev != null){
                    if (curNode.val < prev.val){
                        if (firstFound){
                            mistakenNode1 = prev;
                            mistakenNode2 = curNode;
                            firstFound = false;
                        }
                        else{
                            mistakenNode2 = curNode;
                        }
                    }
                }
                prev = curNode;
                curNode = curNode.right;
            }
            else{
                //curNode.left != null, so find rightmost(predecessor)
                // node in left subtree
                TreeNode movingNode = curNode.left;
                while (movingNode.right != null && movingNode.right != curNode){
                    movingNode = movingNode.right;
                }
                if (movingNode.right == null){
                    movingNode.right = curNode;
                    curNode = curNode.left;
                    // This is important, we should
                    // not add this statement since this is not the right time
                    // To be more specific, now curNode = curNode.left,
                    // so the prev should points to curNode.left.predecessor,
                    // which is exactly what prev used to be
                    // prev = movingNode;
                }
                else{
                    movingNode.right = null;
                    prev = movingNode;
                     if (prev != null){
                        if (curNode.val < prev.val){
                            if (firstFound){
                                mistakenNode1 = prev;
                                mistakenNode2 = curNode;
                                firstFound = false;
                            }
                            else{
                                mistakenNode2 = curNode;
                            }
                        }
                    }
                    prev = curNode;
                    curNode = curNode.right;
                }
            }
        }
        
        // swap
        int swapVal = mistakenNode1.val;
        mistakenNode1.val = mistakenNode2.val;
        mistakenNode2.val = swapVal;
    }
}