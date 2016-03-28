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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> resolvingNodes = new LinkedList<TreeNode>();
        resolvingNodes.offer(root);
        List<Integer> rightMostNodes = new ArrayList<Integer>();
        while(!resolvingNodes.isEmpty()){
            List<TreeNode> nodeListInCurLevel = new ArrayList<TreeNode>();
            while(!resolvingNodes.isEmpty()){
                nodeListInCurLevel.add(resolvingNodes.poll());
            }
            rightMostNodes.add(
                nodeListInCurLevel.get(nodeListInCurLevel.size() - 1).val);
            for (TreeNode curNode : nodeListInCurLevel){
                if (curNode.left != null){
                    resolvingNodes.offer(curNode.left);
                }
                if (curNode.right != null){
                    resolvingNodes.offer(curNode.right);    
                }
            }
        }
        return rightMostNodes;
    }
}