public class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroLength = 0;
        int idx = 0;
        while (idx < nums.length){
            if (nums[idx] != 0){
                if (idx != nonZeroLength){
                    nums[nonZeroLength] = nums[idx];
                    nums[idx] = 0;
                }
                nonZeroLength ++;
            }
            idx ++;
        }
    }
}