/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null,
        so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int idx = 0;
        int result = 0;
        ListNode cur = head;
        while (cur != null){
            if (rand.nextInt(idx + 1) == idx){
                result = cur.val;
            }
            idx ++;
            cur = cur.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */