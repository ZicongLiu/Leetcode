public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] sums = new int[nums.length];
        
        sums[0] = nums[0];
        sums[1] = Math.max(nums[0],nums[1]);
        for (int idx = 2; idx < nums.length ; idx ++){
            sums[idx] = Math.max(sums[idx - 2] + nums[idx], sums[idx - 1]);
        }
        return sums[nums.length - 1];
    }
}