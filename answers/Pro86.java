/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode dummySmall = new ListNode(-1);
        ListNode dummyLarge = new ListNode(-1);
        
        ListNode tailSmall = dummySmall;
        ListNode tailLarge = dummyLarge;
        
        ListNode curNode = head;
        while (curNode != null){
            if (curNode.val < x){
                tailSmall.next = curNode;
                tailSmall = tailSmall.next;
            }
            else if(curNode.val >= x){
                tailLarge.next = curNode;
                tailLarge = tailLarge.next;
            }
            
            curNode = curNode.next;
        }
        tailLarge.next = null;
        
        tailSmall.next = dummyLarge.next;
        
        return dummySmall.next;
    }
}