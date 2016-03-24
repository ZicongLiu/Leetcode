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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode former = dummy;
        ListNode cur = dummy.next;
        ListNode next = cur.next;
        while(next != null){
            if (cur.val == next.val){
                int val = cur.val;
                
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                if (cur == null){
                    former.next = null;
                    return dummy.next;
                }
                else {
                    next = cur.next;
                }
            }
            else{
                former.next = cur;
                former = cur;
                
                cur = cur.next;
                next = cur.next;
            }
        }
        former.next = cur;
        return dummy.next;
    }
}