public class Solution {
    public boolean isPowerOfTwo(int n) {
        double div = Math.log(n) / Math.log(2);
        double diff = Math.abs(div -  Math.round(div));
        if (diff <= 0.0000000001)
            return true;
        else
            return false;
    }
}