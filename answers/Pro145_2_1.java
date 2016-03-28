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
     boolean visited;
     public TagTreeNode(TreeNode node, boolean visited){
         this.node = node;
         this.visited = visited;
     }
 }
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<TagTreeNode> traversalStack = new Stack<TagTreeNode>();
        traversalStack.push(new TagTreeNode(root, false));
        while (!traversalStack.isEmpty()){
            TagTreeNode curNode = traversalStack.pop();
            if(curNode.visited){
                result.add(curNode.node.val);
            }
            else{
                curNode.visited = true;
                traversalStack.push(curNode);
                if (curNode.node.right != null){
                    traversalStack.push(
                        new TagTreeNode(curNode.node.right,false));
                }    
                if (curNode.node.left != null){
                    traversalStack.push(
                        new TagTreeNode(curNode.node.left,false));
                }
            }
        }
        return result;
    }
}