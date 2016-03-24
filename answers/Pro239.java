public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0){
            return nums;
        }
        LinkedList<Integer> windows = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        for (int idx = 0 ; idx < nums.length ; idx++){
            int cur = nums[idx];
            if (!windows.isEmpty() && windows.getFirst() <= idx - k){
                windows.removeFirst();
            }
            while (!windows.isEmpty() && cur > nums[windows.getLast()]){
                windows.removeLast();
            }
            windows.addLast(idx);
            if (idx >= k - 1){
                result[idx - k + 1] = nums[windows.getFirst()];
            }
        }
        return result;
    }
}