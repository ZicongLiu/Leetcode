/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TagTreeNode{
     TreeNode node;
     int size;
     TagTreeNode left;
     TagTreeNode right;
     public TagTreeNode(TreeNode node, int size){
         this.node = node;
         this.size = size;
     }
 }
public class Solution {
    public TagTreeNode buildNode(TreeNode root){
        if (root == null){
            return null;
        }
        TagTreeNode leftTagNode = buildNode(root.left);
        TagTreeNode rightTagNode = buildNode(root.right);
        int lSize = getSize(leftTagNode);
        int rSize = getSize(rightTagNode);
        int newSize = 1 + lSize + rSize;
        
        TagTreeNode tagNode = new TagTreeNode(root, newSize);
        tagNode.left = leftTagNode;
        tagNode.right = rightTagNode;
        return tagNode;
    }
    public int getSize(TagTreeNode curNode){
        if (curNode == null){
            return 0;
        }
        return curNode.size;
    }
    public int kthSmallest(TreeNode root, int k) {
        TagTreeNode tagRoot = buildNode(root);
        int result = binarySearch(tagRoot, k);
        return result;
    }
    public int binarySearch(TagTreeNode tagNode, int k){
        int size = getSize(tagNode.left);
        if (size + 1 == k){
            return tagNode.node.val;
        }
        else if (size + 1 > k){
            return binarySearch(tagNode.left, k);
        }else{
            return binarySearch(tagNode.right, k - size - 1);
        }
    }
}