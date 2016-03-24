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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null){
            return 0;
        }
        queue.add(root);
        int minDepth = 1;
        while (!queue.isEmpty()){
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            int count = 0;
            while (!queue.isEmpty()){
                list.add(queue.poll());
                count ++;
            }
            for (int i = 0 ; i < count ; i ++){
                TreeNode cur = list.get(i);
                if (cur == null || (cur.left == null && cur.right == null)){
                    return minDepth;
                }else if (cur.left == null){
                    queue.offer(cur.right);
                }else if (cur.right == null){
                    queue.offer(cur.left);
                }else{
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            minDepth ++;
        }
        return minDepth;
    }
}