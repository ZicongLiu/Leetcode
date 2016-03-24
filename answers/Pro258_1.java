public class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while (num != 0){
            int digit = num % 10;
            num /= 10;
            sum += digit;
            if (num == 0){
                if (sum >= 10){
                    num = sum;
                    sum = 0;
                }
            }
        }
        return sum;
    }
}