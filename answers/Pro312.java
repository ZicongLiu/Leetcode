public class Solution {
    public int maxCoins(int[] nums) {
        int[] totalNums = new int[nums.length + 2];
        totalNums[0] = totalNums[totalNums.length - 1] = 1;
        for (int i = 0 ; i < nums.length ; i ++){
            totalNums[i + 1] = nums[i];
        }
        if (nums.length == 0){
            return 0;
        }
        int dp[][] = new int[totalNums.length][totalNums.length];
        for (int len = 2 ; len < totalNums.length ; len ++){
            for (int start = 0 ; start < totalNums.length - len ; start ++){
                int end = start + len;
                for (int mid = start + 1 ; mid < end ; mid ++){
                    dp[start][end] = Math.max(dp[start][end], totalNums[start] * totalNums[mid] * totalNums[end] + dp[start][mid] + dp[mid][end]);
                }
            }
        }
        
        return dp[0][totalNums.length - 1];
    }
}