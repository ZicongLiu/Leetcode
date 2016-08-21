public class Solution {
    int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        int used = 0;
        if (n == 0){
            return 1;
        }
        if (n > 10){
            return countNumbersWithUniqueDigits(10);
        }
        
        countNumber(1, n, used);
        return count;
    }
    private void countNumber(int digitIdx, int n, int used){
        if (digitIdx > n){
            count ++;
            return;
        }
        for (int digit = 0 ; digit <= 9 ; digit ++){
            int mask = (1 << digit);
            if ((mask & used) != 0){
                continue;
            }
            if (digit != 0 || used != 0){
                used |= mask;
            }
            
            countNumber(digitIdx + 1, n, used);
            used &= (~mask);
        }
    }
}