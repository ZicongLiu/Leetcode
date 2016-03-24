public class Solution {
    public int reverse(int x) {
        int maxHead = Integer.MAX_VALUE / 10;
        int maxTail = Integer.MAX_VALUE % 10;
        int minTail = Integer.MIN_VALUE % 10;
        int origin = x;
        int sum = 0;
        while (origin != 0){
            int digit = origin % 10;
            origin /= 10;
            if (Math.abs(sum) > maxHead && digit != 0){
                return 0;
            }
            if (Math.abs(sum) == maxHead){
                if ((digit > 0 && digit > maxTail)
                 || (digit < 0 && digit < minTail))
                return 0;
            }
            sum = sum * 10 + digit;
        }
        return sum;
    }
}