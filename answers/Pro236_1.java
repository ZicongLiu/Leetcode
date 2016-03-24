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
    public TreeNode findChild(TreeNode curNode, TreeNode targetP, TreeNode targetQ){
        if (curNode == null){
            return null;
        }
        if (curNode == targetP || curNode == targetQ){
            return curNode;
        }
        TreeNode leftChild = findChild(curNode.left, targetP , targetQ);
        TreeNode rightChild = findChild(curNode.right, targetP, targetQ);
        if (leftChild != null && rightChild != null){
            return curNode;
        }
        return (leftChild == null) ? rightChild : leftChild;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findChild(root, p, q);
        return lca;
    }
}