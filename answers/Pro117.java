/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode currentLevelHead = root, nextLevelHead = null;
        
        while (currentLevelHead != null){
            TreeLinkNode currentNode = currentLevelHead;
            TreeLinkNode prevTail = null;
            
            while (currentNode != null){
                if (currentNode.left != null && currentNode.right != null){
                    currentNode.left.next = currentNode.right;
                }
                if (currentNode.left == null && currentNode.right == null){
                    currentNode = currentNode.next;
                    continue;
                }
                else{
                    TreeLinkNode firstNodeInRow = (currentNode.left == null)
                     ? currentNode.right : currentNode.left;
                    if (nextLevelHead == null){
                        nextLevelHead = firstNodeInRow;
                        prevTail = firstNodeInRow;
                    }
                    else{
                        prevTail.next = firstNodeInRow;
                    }
                    
                    while (prevTail.next != null){
                        prevTail = prevTail.next;
                    }
                }
                
                currentNode = currentNode.next;
            }
            currentLevelHead = nextLevelHead;
            nextLevelHead = null;
        }
    }
}