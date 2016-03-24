/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
		public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null){
			return true;
		}
		ListNode cur = head;
		// get middle
		ListNode mid = getMid(head);
		// reverse from mid to end
		mid = reverse(mid);
		// check equations
		while (mid != null){
			if (mid.val != cur.val){
				return false;
			}
			mid = mid.next;
			cur = cur.next;
		}
		return true;
	}
	
	public ListNode getMid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.next;
	}
	
	public ListNode reverse(ListNode head){
	    if (head.next == null){
			return head;
		}
		ListNode p,q,r;
		p = head;
		q = p.next;
		r = q.next;
		p.next = null;
		while (q.next != null){
			q.next = p;
			p = q;
			q = r;
			r = q.next;
		}
		q.next = p;
		return q;
	}
	
}