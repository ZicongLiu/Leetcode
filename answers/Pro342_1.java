public class Solution {
    public boolean isPowerOfFour(int num) {
        if (((num & (num - 1)) != 0) || num == 0){
            return false;
        }
        while ((num & 3) == 0){
            num >>= 2;
        }
        return ((num & 3) == 1);
    }
}