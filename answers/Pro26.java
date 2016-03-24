public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int formerElement = nums[0];
        int length = 1;
        
        for (int idx = 0 ; idx < nums.length ; idx ++){
            if (nums[idx] != formerElement){
                nums[length ++] = nums[idx];
                formerElement = nums[idx];
            }
        }
        return length;
    }
}