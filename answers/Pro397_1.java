public class Solution {
    public int integerReplacement(int n) {
        if (n == 0 || n == 1){
            return 0;
        }
        // This is important that 3 is a special case
        if (n == 3){
            return 2;
        }
        if ((n & 1) == 0){
            return 1 + integerReplacement(n >>> 1);
        }
        else{
            return Math.min(integerReplacement(n + 1),
             integerReplacement(n - 1)) + 1;
        }
    }
}