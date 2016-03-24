/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode currentListNode;
    public TreeNode buildTree(int low,  int high){
        if (low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode leftChild = buildTree(low , mid - 1);
        
        TreeNode rootNode = new TreeNode(currentListNode.val);
        currentListNode = currentListNode.next;
        
        rootNode.left = leftChild;
        TreeNode rightChild = buildTree(mid + 1 , high);
        rootNode.right = rightChild;
        return rootNode;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        currentListNode = head;
        ListNode curNode = head;
        int length = 0;
        while (curNode != null){
            length ++;
            curNode = curNode.next;
        }
        
        return buildTree(0 , length - 1);        
    }
}