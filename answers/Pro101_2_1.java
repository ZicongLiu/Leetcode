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
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> indexes = new LinkedList<Integer>();
        queue.offer(root);
        indexes.offer(0);
        int level = 0;
        while (!queue.isEmpty()){
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            ArrayList<Integer> indexList = new ArrayList<Integer>();
            
            while (!queue.isEmpty()){
                list.add(queue.poll());
                indexList.add(indexes.poll());
            }
            if (list.size() % 2 == 1 && level != 0){
                return false;
            }
            int i = 0 , j = list.size() - 1;
            while (i < j){
                if (list.get(i).val != list.get(j).val
                 || indexList.get(i) + indexList.get(j) != (int)Math.pow(2, level) - 1){
                    return false;
                }
                                    
                i++;
                j--;
            }
            for (int idx = 0 ; idx < list.size() ; idx ++){
                TreeNode node = list.get(idx);
                int index = indexList.get(idx);
                if (node.left != null){
                    queue.offer(node.left);
                    indexes.offer(index * 2);
                }
                if (node.right != null){
                    queue.offer(node.right);
                    indexes.offer(index * 2 + 1);
                }
            }
            level ++;
        }
        return true;
    }
}