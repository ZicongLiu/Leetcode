public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int dp[] = new int[nums.length];
        int max = 0;
        for (int idx = 0 ; idx < nums.length ; idx++){
            dp[idx] = 1;
            for (int formerIdx = 0 ; formerIdx < idx ; formerIdx ++){
                if (nums[idx] > nums[formerIdx]){
                    dp[idx] = Math.max(dp[idx], dp[formerIdx] + 1);
                }
            }
            max = Math.max(max, dp[idx]);
        }
        
        return max;
    }
}