public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int tmp = x;
        int div = 1;
        while (tmp / 10 != 0){
            div *= 10;
            tmp /= 10;
        }
        while (x != 0){
            int l = x / div;
            int r = x % 10;
            if (l != r){
                return false;
            }
            x = x % div / 10;
            div /= 100;
        }   
        return true;
    }
}