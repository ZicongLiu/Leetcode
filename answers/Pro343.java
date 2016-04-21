public class Solution {
    public int integerBreak(int n) {
        int max = -1;
        for (int digit = 2 ; digit <= n ; digit++){
            int product = 1;
            int base = n / digit;
            int rem = n % digit;
            for (int prodIdx = 0 ; prodIdx < digit ; prodIdx ++){
                product *= (rem <= 0) ? base : (base + 1);
                rem --;
            }
            max = Math.max(product, max);
        }
        return max;
    }
}