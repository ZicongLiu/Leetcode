public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int maxSum = 0;
        int[] maxProfit = new int[prices.length];
        int[] maxProfitRev = new int[prices.length];
        
        int max = 0;
        int min = prices[0];
        for (int i = 1 ; i < prices.length ; i ++){
            int diff = prices[i] - min;
            max = Math.max(diff, max);
            if (prices[i] < min){
                min = prices[i];
            }
            maxProfit[i] = max;
        }
        max = 0;
        int high = prices[prices.length - 1];
        for (int i = prices.length - 2 ; i >= 0 ; i--){
            int diff = high - prices[i];
            max = Math.max(max, diff);
            if (prices[i] > high){
                high = prices[i];
            }
            maxProfitRev[i] = max;
        }
        for (int i = 0 ; i < prices.length ; i ++){
            maxSum = Math.max(maxSum, maxProfit[i] + maxProfitRev[i]);
        }
        return maxSum;
    }
}