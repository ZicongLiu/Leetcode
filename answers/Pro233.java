public class Solution {
    public int countDigitOne(int n) {
        if (n < 0){
            return 0;
        }
        int base = 1;
        int num = n;
        int count = 0;
        while (num != 0){
            int lower = n - base * num;
            int quo = num / 10;
            int rem = num % 10;
            switch(rem){
                case 0:
                    count += quo * base;
                    break;
                case 1:
                    count += quo * base + lower + 1;
                    break;
                default:
                    count += (quo + 1) * base;
            }
            base *= 10;
            num /= 10;
        }
        return count;
    }
}