public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }
        int sum = 1;
        int descLen = 0;
        int ascCandyCnt = 1;
        int descCandyCnt = 0;
        for (int i = 1 ; i < ratings.length ; i++){
            if (ratings[i] > ratings[i - 1]){
                if (descLen != 0){
                    ascCandyCnt = 1;
                }
                ascCandyCnt ++;
                sum += ascCandyCnt;
                descLen = 0;
                descCandyCnt = 0;
            }
            else if (ratings[i] == ratings[i - 1]){
                sum ++;
                ascCandyCnt = 1;
                descLen = 0;
                descCandyCnt = 0;
            } else{
                // ratings[i] < ratings[i - 1]
                descLen ++;
                if (ascCandyCnt <= descLen){
                    sum ++;
                }
                descCandyCnt ++;
                sum += descCandyCnt;
            }
        }
        
        return sum;
    }
}