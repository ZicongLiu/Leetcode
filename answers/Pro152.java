public class Solution {
    public int maxProduct(int[] nums) {
        int[] curMin = new int[nums.length];
        int[] curMax = new int[nums.length];
        if (nums.length == 0){
            return 0;
        }
        int totalMax = nums[0];
        curMax[0] = curMin[0] = nums[0];
        
        for (int idx = 1 ; idx < nums.length ; idx ++){
            curMax[idx] = Math.max(
                Math.max(curMax[idx - 1] * nums[idx],
                    curMin[idx - 1] * nums[idx]),
                nums[idx]);
            curMin[idx] = Math.min(
                Math.min(curMax[idx - 1] * nums[idx],
                    curMin[idx - 1] * nums[idx]),
                nums[idx]);
            totalMax = Math.max(curMax[idx], totalMax);
        }
        
        return (int)totalMax;
    }
}