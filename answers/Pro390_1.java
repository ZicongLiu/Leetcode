public class Solution {
    public int lastRemaining(int n) {
        return lastRemaining(n, true);
    }
    
    private int lastRemaining(int n, boolean fromLeft){
        if (n == 1){
            return 1;
        }
        if (!fromLeft && n % 2 == 0){
            return lastRemaining(n / 2, !fromLeft) * 2 - 1;
        }
        else{
            return lastRemaining(n / 2, !fromLeft) * 2;
        }
    }
}