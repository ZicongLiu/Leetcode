/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        ListNode cur = dummy;
        while (cur.next != null){
            len++;
            cur = cur.next;
        }
        k = k % len;
        ListNode fast = head;
        while (k-- > 0){
            fast = fast.next;
            if (k > 0 && fast == null){
                fast = head;
            }
        }
        ListNode slow = head;
        if (fast == null){
            return head;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}