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
    public TreeNode buildNode(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = buildNode(nums, start, mid - 1);
        rootNode.right = buildNode(nums, mid + 1 , end);
        
        return rootNode;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }
}