/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == m){
            return head;
        }
        int idx = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode prev = cur;
        while (cur.next != null && idx < m) {
            prev = cur;
            cur = cur.next;
            idx++;
        }
        ListNode tail1 = prev;
        ListNode tail2 = cur;
        ListNode next = cur.next;
        while (cur.next != null && idx < n){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
            idx++;
        }
        tail2.next = next;
        tail1.next = cur;
        return dummy.next;
    }
}