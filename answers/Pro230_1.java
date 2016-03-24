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
    List<Integer> result = new ArrayList<Integer>();
    public void findKth(TreeNode curNode){
        if (curNode == null){
            return;
        }
        else{
            findKth(curNode.left);
            result.add(curNode.val);
            findKth(curNode.right);
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        findKth(root);
        
        return result.get(k - 1);
    }
}