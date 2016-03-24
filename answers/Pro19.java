/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (n-- > 0) {
            p1 = p1.next;
        }
        if (p1 == null){
            return head.next;
        }
        ListNode prev = p2;
        while (p1 != null) {
            p1 = p1.next;
            prev = p2;
            p2 = p2.next;
        }
        prev.next = p2.next;
        return head;
    }
}