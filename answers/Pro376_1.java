public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int maxLength = -1;
        // last diff, 0 for positive, 1 for negative
        int[][] dp = new int[nums.length][2];
        
        for (int idx = 0; idx < nums.length ; idx ++){
            dp[idx][0] = 1;
            dp[idx][1] = 1;
            for (int formerIdx = idx - 1 ; formerIdx >= 0 ; formerIdx --){
                int maxPositive = -1, maxNegative = -1;
                int diff = nums[idx] - nums[formerIdx];
                if (diff > 0){
                    maxPositive = Math.max(dp[formerIdx][1], maxPositive);
                }
                else if (diff < 0){
                    maxNegative = Math.max(dp[formerIdx][0], maxPositive);
                }
                else{
                    continue;
                }
                dp[idx][0] = Math.max(dp[idx][0], maxPositive + 1);
                dp[idx][1] = Math.max(dp[idx][1], maxNegative + 1);
                maxLength = Math.max(maxLength , Math.max(dp[idx][0], dp[idx][1]));
            }
        }
        
        return Math.max(maxLength, 1);
    }
}