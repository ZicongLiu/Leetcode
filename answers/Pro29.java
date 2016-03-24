public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0){
            return Integer.MAX_VALUE;
        }
        
        int result = 0;
        
        if(dividend==Integer.MIN_VALUE){
            result = 1;
            dividend += Math.abs(divisor);
        }
        if(divisor==Integer.MIN_VALUE)
            return result;
            
        // boolean negative = ((dividend^divisor)>>>31==1)?true:false;
        boolean negative = (dividend > 0 && divisor < 0||
                            dividend < 0 && divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        if (dividend == 0 || dividend < divisor){
            return negative ? -result : result;
        }

        
        int count = 0;
        // while (dividend < divisor){
        while (divisor <= (dividend >> 1)){
            divisor <<= 1;
            count ++;
        }
        while (count >= 0){
            while (dividend >= divisor){
                dividend -= divisor;
                result += (1 << count);
            }
            divisor >>= 1;
            count --;
        }
        if (result == Integer.MIN_VALUE && !negative){
            return Integer.MAX_VALUE;
        }
        
        return negative ? -result : result;
    }
}   