public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int number = nums[0];
        for (int idx = 1; idx < nums.length ; idx++){
            number ^= nums[idx];
        }
        
        return number;
    }
}