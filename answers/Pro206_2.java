/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        ListNode retNode = reverseList(nextNode);
        nextNode.next = head;
        return retNode;
    }
}