public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] sums = new int[nums.length];
        // not robbing the 1st house
        sums[0] = 0;
        sums[1] = nums[1];
        for (int idx = 2 ; idx < nums.length ; idx ++){
            sums[idx] = Math.max(sums[idx - 1], sums[idx - 2] + nums[idx]);
        }
        int max = sums[nums.length - 1];
        // robbing the 1st house
        sums[0] = nums[0];
        sums[1] = Math.max(nums[0],nums[1]);
        for (int idx = 2; idx < nums.length - 1 ; idx ++){
            sums[idx] = Math.max(sums[idx - 1], sums[idx - 2] + nums[idx]);
        }
        return Math.max(max, sums[nums.length - 2]);
    }
}