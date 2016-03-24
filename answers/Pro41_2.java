public class Solution {
    public int firstMissingPositive(int[] nums) {
        int idx = 0;
        while (idx < nums.length){
            int value = nums[idx] - 1;
            if (value >= nums.length || value < 0){
                idx ++;
            }
            else{
                if (value + 1 == nums[value] || nums[idx] == idx + 1){
                    idx ++;
                }
                else{
                    nums[idx] = nums[value];
                    nums[value] = value + 1;
                }
            }
        }
        
        for (idx = 0 ; idx < nums.length ; idx ++){
            if (nums[idx] != idx + 1){
                return idx + 1;
            }
        }
        return nums.length + 1;
    }
}