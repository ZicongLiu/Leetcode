public class Solution {
    public boolean canJump(int[] nums) {
        int des = nums.length - 1;
        for(int i = des - 1; i >= 0; i--){
            if(nums[i] >= des - i){
                des = i;
            }
        }
        return des <= 0;
    }
}