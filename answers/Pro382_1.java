/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int length = 1;
    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null,
        so it contains at least one node. */
    public Solution(ListNode head) {
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
            length ++;
        }
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int rand = (int) Math.ceil(Math.random() * length) - 1;
        // System.out.println(rand + " in " + length);
        ListNode cur = head;
        while (rand > 0){
            cur = cur.next;
            rand --;
        }
        return cur.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */