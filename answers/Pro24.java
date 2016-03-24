/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = head;
        dummy.next = head.next;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null && next != null){
            ListNode tmp = next.next;
            tail.next = next;
            next.next = cur;
            cur.next = null;
            tail = cur;
            cur = tmp;
            if (cur != null){
                next = cur.next;
            }
            if (next == null){
                tail.next = cur;
            }
        }
        return dummy.next;
    }
}