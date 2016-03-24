public class Solution {
    public double myPow(double x, int n) {
        if (x - 0.0000001 == 0){
            return 0.0;
        }
        if (n < 0){
            return (1 / pow(x, (long)(-n)));
        }
        return pow(x, (long)n);
    }
    public double pow(double x, long n){
        if (n == 0){
            return 1.0;
        }
        if (n == 1){
            return x;
        }
        double sqrtVal = pow(x, (n >>> 1));
        if ((n & 1) == 1){
            // odd
            return x * sqrtVal * sqrtVal;
        }
        else{
            return sqrtVal * sqrtVal;
        }
    }
}