/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        if (root != null){
            stack.push(root);
        
            while (root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = stack.pop();
        
        TreeNode rightChild = nextNode.right;
        while (rightChild != null){
            stack.push(rightChild);
            rightChild = rightChild.left;    
        }
        return nextNode.val;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */