public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return nums.length;
        }
        int length = 1;
        int formerElement = nums[0];
        boolean allowAnother = true;
        
        for (int idx = 1 ; idx < nums.length ; idx ++){
            if (formerElement != nums[idx]){
                formerElement = nums[idx];
                nums[length ++] = nums[idx];
                allowAnother = true;
            }
            else{
                // former == current
                if (allowAnother){
                    nums[length ++] = nums[idx];
                    allowAnother = false;
                }
            }
        }
        
        return length;
    }
}