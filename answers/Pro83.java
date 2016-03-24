/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null){
            while (next != null && cur.val == next.val){
                cur.next = next.next;
                next = next.next;
            }
            if (next == null)
                return head;
            cur = next;
            next = next.next;
        }
        return head;
    }
}