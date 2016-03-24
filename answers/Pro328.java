/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode evenHead = next;
        while (next != null){
            cur.next = next.next;
            if (cur.next == null){
                cur.next = evenHead;
                return head;
            }
            next.next = cur.next.next;
            cur = cur.next;
            next = next.next;
        }
        cur.next = evenHead;
        return head;
    }
}