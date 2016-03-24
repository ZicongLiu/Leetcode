/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> copyMap
         = new HashMap<RandomListNode,RandomListNode>();
        
        RandomListNode curNode = head;
        RandomListNode dummy = new RandomListNode(-1);        
        RandomListNode curCopyNode = dummy;
        
        while (curNode != null){
            RandomListNode newCopyNode = new RandomListNode(curNode.label);
            curCopyNode.next = newCopyNode;
            copyMap.put(curNode, newCopyNode);
            curNode = curNode.next;
            curCopyNode = curCopyNode.next;
        }
        
        curNode = head;
        curCopyNode = dummy;
        
        while(curNode != null){
            curCopyNode.next.random = copyMap.get(curNode.random);
            curNode = curNode.next;
            curCopyNode = curCopyNode.next;
        }
        
        return dummy.next;
    }
}