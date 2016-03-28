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
    List<String> paths = new ArrayList<String>();
    public void traversePath(TreeNode curNode, String prefix){
        if (curNode == null)
            return;
        if (curNode.left == null && curNode.right == null)
            paths.add(prefix + curNode.val);
        prefix += curNode.val + "->";
        if (curNode.left != null)
            traversePath(curNode.left , prefix);
        if (curNode.right != null)
            traversePath(curNode.right, prefix);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        traversePath(root, "");
        return paths;
    }
}