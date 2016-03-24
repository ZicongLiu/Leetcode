public class Solution {
    public int maxProfit(int[] prices) {
    	int max = 0;
    	if (prices.length == 0){
    		return 0;
    	}
    	int curMin = prices[0];
        for (int i = 1 ; i < prices.length ; i++){
        	int profit = prices[i] - curMin;
        	if (profit > max){
        		max = profit;
        	}
        	if (prices[i] < curMin){
        		curMin = prices[i];
        	}
        }
        return max;
    }
}