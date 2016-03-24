public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        int curMax = nums[0] + 1;
        
        for (int idx = 0 ; idx < nums.length ; idx ++){
            curMax --;
            curMax = Math.max(nums[idx] , curMax);
            
            if (curMax == 0){
                return false;
            }
            if (curMax + idx >= nums.length - 1){
                return true;
            }
            
        }
        
        return true;
    }
}