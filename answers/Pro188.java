public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        // for those special input data
        if (k > prices.length){
            int sum = 0;
            for (int i = 1 ; i < prices.length ; i++){
                if (prices[i] > prices[i - 1]){
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
        else{
            int[][] total = new int[prices.length][k + 1];
            int[][] part = new int[prices.length][k + 1];
            for (int i = 1 ; i < prices.length ; i++){
                int diff = prices[i] - prices[i - 1];
                for (int j = k ; j >= 1 ; j--){
                    part[i][j] = Math.max(total[i - 1][j - 1] + Math.max(0, diff), part[i - 1][j] + diff);
                    total[i][j] = Math.max(part[i][j], total[i - 1][j]);
                }
            }
            
            return total[prices.length - 1][k];
        }
    }
}