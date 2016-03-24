/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lenA = 1 ; int lenB = 1;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA.next != null){
            lenA ++;
            curA = curA.next;
        }
        while (curB.next != null){
            lenB ++;
            curB = curB.next;
        }
        if (curA.val != curB.val){
            return null;
        }
        ListNode longer, shorter;
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB){
            longer = headA;
            shorter = headB;
        }
        else{
            longer = headB;
            shorter = headA;
        }
        boolean found = false;
        ListNode inter = null;
        while (diff -- > 0){
            longer = longer.next;
        }
        while(longer != null){
            if (!found && longer.val == shorter.val){
                found = true;
                inter = longer;
            }
            if (longer.val != shorter.val){
                found = false;
                inter = null;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return inter;
    }
}