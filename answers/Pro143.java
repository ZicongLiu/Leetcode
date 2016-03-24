/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
public void reorderList(ListNode head) {
        if (head == null || head.next == null|| head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // reverse latter half
        ListNode cur = slow;
        ListNode next = cur.next;
        cur.next = null;
        while (next != null){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        // cur is the reversed list
        ListNode p = head;
        ListNode q = cur;
        while (p.next != null){
            ListNode r = p.next;
            ListNode s = q.next;
            p.next = q;
            q.next = r;
            p = r;
            q = s;
        }
        p.next = q;
    }
}