/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);   
        dummy.next = head;
        ListNode curNode = head.next;
        ListNode prevNode = head;
        
        while (curNode != null){
            // find insertion position
            boolean found = false;
            ListNode searchNode = dummy.next;
            ListNode searchPrevNode = dummy;
            while (searchNode != curNode){
                if (curNode.val < searchNode.val){
                    // reconnect curNode
                    prevNode.next = curNode.next;
                    
                    // connect searchNode & currentNode
                    searchPrevNode.next = curNode;
                    curNode.next = searchNode;
                    
                    curNode = prevNode.next;
                    found = true;
                    break;
                }
                searchPrevNode = searchNode;
                searchNode = searchNode.next;
            }
            if (curNode == searchNode){
                // no need to change
                prevNode = curNode;
                curNode = curNode.next;
                continue;
            }
            
            // insert node
            if (found){
                continue;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        
        return dummy.next;
    }
}