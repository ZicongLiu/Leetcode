/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private static final Comparator<ListNode> listComparator
     = new Comparator<ListNode>(){
      @Override
      public int compare(ListNode x,  ListNode y){
          return x.val - y.val;
      }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        Queue<ListNode> queue 
        = new PriorityQueue<ListNode>(lists.length, listComparator);
        for (ListNode list : lists){
            if (list != null){
                queue.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!queue.isEmpty()){
            ListNode curNode = queue.poll();
            head.next = curNode;
            head = head.next;
            if (curNode.next != null){
                queue.offer(curNode.next);
            }
        }
        
        return dummy.next;
    }
}