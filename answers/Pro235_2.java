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
    public List<TreeNode> getPath(TreeNode startNode, TreeNode target){
        TreeNode curNode = startNode;
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        while (curNode != target){
            result.add(curNode);
            if (curNode.val > target.val){
                curNode = curNode.left;
            }else if (curNode.val < target.val){
                curNode = curNode.right;
            }else{
                break;
            }
        }
        result.add(target);
        
        return result;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<TreeNode>();
        List<TreeNode> pathQ = new ArrayList<TreeNode>();
        
        pathP = getPath(root, p);
        pathQ = getPath(root, q);
        
        for (int idx = 0 ; idx < Math.min(pathP.size() , pathQ.size()) ; idx ++){
            if (pathP.get(idx) != pathQ.get(idx)){
                return pathP.get(idx - 1);
            }
        }
        return (pathP.size() > pathQ.size()) ? pathQ.get(pathQ.size() - 1)
         : pathP.get(pathP.size() - 1) ;
    }
}