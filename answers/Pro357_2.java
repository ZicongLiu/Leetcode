public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int sum = 10, product = 9;
        for (int digit = 2 ; digit <= Math.min(n, 10) ; digit ++){
            product *= (11 - digit);
            sum += product;
        }
        
        return sum;
    }
}