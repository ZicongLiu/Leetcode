/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode l1 = head1, l2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null){
            int digit1 = l1.val;
            int digit2 = l2.val;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            cur.next = newNode;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null){
            while (l2 != null){
                int digit = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                ListNode newNode = new ListNode(digit);
                cur.next = newNode;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        else if (l2 == null){
            while (l1 != null){
                int digit = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                ListNode newNode = new ListNode(digit);
                cur.next = newNode;
                cur = cur.next;
                l1 = l1.next;
                
            }
        }
        if (l1 == null && l2 == null){
            if (carry > 0){
                ListNode newNode = new ListNode(carry);
                cur.next = newNode;
            }
            
        }
        return dummy.next;
    }
}