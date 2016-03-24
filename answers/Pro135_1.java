public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }
        int candies[] = new int[ratings.length];
        for (int i = 0 ; i < ratings.length - 1 ; i++){
            if (ratings[i] < ratings[i + 1]){
                if (candies[i] == 0){
                    candies[i] = 1;
                }
                candies[i + 1] = candies[i] + 1;                                        
            }
        }
        for (int i = ratings.length - 1 ; i > 0 ; i--){
            if (ratings[i] < ratings[i - 1]){
                if (candies[i] == 0){
                    candies[i] ++;
                }
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
        }
        
        for (int i = 0 ; i < ratings.length ; i ++){
            if (candies[i] == 0){
                candies[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0 ; i < candies.length ; i ++){
            sum += candies[i];
        }
        
        return sum;
    }
}