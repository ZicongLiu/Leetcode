public class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxDp = new int[nums.length];
        if (nums.length == 0){
            return 0;
        }
        int totalMax = nums[0];
        maxDp[0] = nums[0];
        
        for (int idx = 1 ; idx < nums.length ; idx ++){
            maxDp[idx] = Math.max(maxDp[idx - 1] + nums[idx], nums[idx]);
            totalMax = Math.max(maxDp[idx], totalMax);
        }
        
        return totalMax;
    }
}