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

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> traversalStack = new Stack<TreeNode>();
        traversalStack.push(root);
        
        while (!traversalStack.isEmpty()){
            TreeNode curNode = traversalStack.pop();
            result.add(curNode.val);
            if (curNode.left != null){
                traversalStack.push(curNode.left);
            }
            if (curNode.right != null){
                traversalStack.push(curNode.right);
            }
        }
        return reverseList(result);
    }
    
    private List<Integer> reverseList(List<Integer> list){
        int idxStart = 0 , idxEnd = list.size() - 1;
        
        while (idxStart < idxEnd){
            Integer swapInt = list.get(idxStart);
            list.set(idxStart, list.get(idxEnd));
            list.set(idxEnd, swapInt);
            idxStart ++;
            idxEnd --;
        }
        
        return list;
    }
}