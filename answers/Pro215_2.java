public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        for (int idx = 0 ; idx < k ; idx ++){
            heap.add(nums[idx]);
        }
        for (int idx = k ; idx < nums.length ; idx ++){
            if (nums[idx] <= heap.peek()){
                continue;
            }
            else{
                heap.poll();
                heap.add(nums[idx]);
            }
        }
        return heap.peek();
    }
}