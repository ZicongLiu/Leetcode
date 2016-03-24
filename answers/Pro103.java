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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        queue.offer(root);
        int direction = 0;
        while (!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<TreeNode>();
            List<Integer> values = new ArrayList<Integer>();
            while (!queue.isEmpty()){
                list.add(queue.poll());    
            }
            
            if (direction == 0){
                for (TreeNode node : list){
                    values.add(node.val);
                }
            }else{
                for (int idx = list.size() - 1; idx >= 0 ; idx --){
                    TreeNode node = list.get(idx);
                    values.add(node.val);
                }
            }
            for (TreeNode node : list){
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            direction = 1 - direction;
            result.add(values);
        }
        return result;
    }
}