/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverse(ListNode start, ListNode end){
        if (start == null)
            return null;
        ListNode cur = start, next = cur.next;
        cur.next = null;
        while (next != null && next != end){
            ListNode backup = next.next;
            next.next = cur;
            cur = next;
            next = backup;
        }
        return cur;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode last = cur;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        while (cur != null){
            int count = k;
            last = cur;
            while (count-- > 0){
                cur = cur.next;
                if (cur == null)
                    break;
            }
            if (count > 0 && cur == null){
                tail.next = last;
                return dummy.next;
            }
            ListNode newPart = reverse(last, cur);
            tail.next = newPart;
            tail = last;
        }
        return dummy.next; 
    }
}