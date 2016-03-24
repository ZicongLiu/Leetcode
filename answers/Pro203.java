/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null || head.next == null)
            return head;
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null){
            while (cur != null && cur.val == val){
                prev.next = cur.next;
                cur = cur.next;
            }
            if (cur == null){
                return head;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}