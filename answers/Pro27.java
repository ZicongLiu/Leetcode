public class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        int length = nums.length;
        
        while (idx < length){
            if (nums[idx] != val){
                idx ++;
                continue;
            }
            while (length > 0 && idx < length && nums[idx] == val){
                int swap = nums[idx];
                nums[idx] = nums[length - 1];
                nums[length - 1] = swap;
                length --;
            }
            idx ++;
        }
        
        return length;
    }
}