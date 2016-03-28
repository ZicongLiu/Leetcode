/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }
        Queue<TreeLinkNode> resolvingNodes = new LinkedList<TreeLinkNode>();
        resolvingNodes.offer(root);
        while (!resolvingNodes.isEmpty()){
            List<TreeLinkNode> nodesCurLevel = new ArrayList<TreeLinkNode>();
            while (!resolvingNodes.isEmpty()){
                nodesCurLevel.add(resolvingNodes.poll());
            }
            for (int nodeIdx = 0 ; nodeIdx < nodesCurLevel.size() ; nodeIdx ++){
                if (nodeIdx != nodesCurLevel.size() - 1){
                    nodesCurLevel.get(nodeIdx).next =
                     nodesCurLevel.get(nodeIdx + 1);
                }
                else{
                    nodesCurLevel.get(nodeIdx).next = null;
                }
                if (nodesCurLevel.get(nodeIdx).left != null){
                    resolvingNodes.offer(nodesCurLevel.get(nodeIdx).left);   
                }
                if (nodesCurLevel.get(nodeIdx).right != null){
                    resolvingNodes.offer(nodesCurLevel.get(nodeIdx).right);   
                }
            } 
        }
    }
}