/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                head.next = cur1;
                cur1 = cur1.next;
                head = head.next;
            }
            else{
                head.next = cur2;
                cur2 = cur2.next;
                head = head.next;
            }
        }
        
        while (cur1 != null){
            head.next = cur1;
            cur1 = cur1.next;
            head = head.next;
        }
        while (cur2 != null){
            head.next = cur2;
            cur2 = cur2.next;
            head = head.next;
        }
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }    
        int begin = 0 , end = lists.length - 1;
        
        while (end > 0){
            begin = 0;
            while (begin < end){
                // two pointers
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin ++;
                end --;
            }
        }
        
        return lists[0];
    }
}