public class Solution {
    public int findNthDigit(int n) {
        int result = -1;
        int level = 1;
        while (n > 0){
            long base = (long) Math.pow(10, level - 1);
            long nextBase = base * 10;
            long curSum = (nextBase - base) * level;
            if (n > curSum){
                n -= curSum;
            }
            else{
                long quo = n / level;
                long rem = n % level;
                long startNum = base + quo;
                if (rem == 0){
                    startNum --;
                    rem = level;
                }
                result = (int)(startNum /
                 Math.pow(10, level - rem)) % 10;
                n = 0;
            }
            level ++;
        }
        
        return result;
    }
}