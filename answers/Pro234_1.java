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
		int len = getLength(head);
		if (len == 0 || len == 1){
			return true;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		int idx = 0;
		ListNode cur = head;
		boolean flag = true;
		while (cur != null){
			stack.push(cur);
			if (len % 2 == 0 && idx == len / 2 - 1){
				break;
			}
			if (len % 2 == 1 && idx == len / 2){
				stack.pop();
				break;
			}
			idx ++;
			cur = cur.next;
		}
		cur = cur.next;
		while (cur != null){
			ListNode compare = stack.pop();
			if (compare.val != cur.val){
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
	
	private int getLength(ListNode head){
		int len = 0;
		ListNode cur = head;
		while (cur != null){
			len ++;
			cur = cur.next;
		}
		return len;
	}
	
}