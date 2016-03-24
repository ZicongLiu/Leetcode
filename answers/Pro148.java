/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
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
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeList(l1, l2);
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            }
            else{
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        while (cur1 != null){
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
        cur.next = null;
        return dummy.next;
    }
}