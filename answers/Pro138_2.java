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
        RandomListNode curNode = head;
        while(curNode != null){
            RandomListNode copyNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = copyNode;
            copyNode.next = nextNode;
            
            curNode = curNode.next.next;
        }
        
        curNode = head;
        while (curNode != null){
            curNode.next.random = (curNode.random != null)
             ? curNode.random.next : null;
            curNode = curNode.next.next;
        }
        
        //recover the original structure, seperate the two list
        curNode = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;
        
        while (curNode != null){
            RandomListNode copyNode = curNode.next;
            RandomListNode nextNode = copyNode.next;
            tail.next = copyNode;
            tail = tail.next;
            
            curNode.next = nextNode;
            curNode = nextNode;
        }
        
        return dummy.next;
    }
}