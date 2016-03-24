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
    public List<TreeNode> findPath(TreeNode curNode, TreeNode targetNode,
     List<TreeNode> curPath){
        if (curNode == null){
            return null;
        }
        curPath.add(curNode);
        if (curNode == targetNode){
            return new ArrayList(curPath);
        }
        List<TreeNode> leftPath = findPath(curNode.left, targetNode, curPath);
        List<TreeNode> rightPath = findPath(curNode.right, targetNode, curPath);
        curPath.remove(curPath.size() - 1);
        return (leftPath == null) ? rightPath : leftPath;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<TreeNode>();
        List<TreeNode> pathQ = new ArrayList<TreeNode>();
        pathP = findPath(root, p, new ArrayList<TreeNode>());
        pathQ = findPath(root, q, new ArrayList<TreeNode>());

        for (int idx = 0 ; idx < Math.min(pathP.size() , pathQ.size()) ; idx ++){
            if (pathP.get(idx) != pathQ.get(idx)){
                return pathP.get(idx - 1);
            }
        }
        // lca is the tail of shorter path
        return (pathP.size() > pathQ.size()) ? pathQ.get(pathQ.size() - 1)
         : pathP.get(pathP.size() - 1);
    }
}