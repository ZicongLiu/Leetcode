/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = null, l2 = null;
        ListNode cycleBegins = null;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast){
                l1 = head;
                l2 = slow;
                
                break;
            }
        }
        if (fast != null && fast.next != null && l1 != null && l2 != null){
            while (l1 != l2){
                l1 = l1.next;
                l2 = l2.next;
            }
            
            cycleBegins = l1;
        }
        return cycleBegins;
    }
}