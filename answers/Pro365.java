public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0){
            return true;
        }
        if (x + y < z){
            return false;
        }
        if (x == 0 && y == 0){
            return false;
        }
        int cd = gcd(x, y);
        return (z % cd == 0);
    }
    
    private int gcd(int x, int y){
        if (x < y){
            return gcd(y, x);
        }
        if (y == 0){
            return x;
        }
        int quo = 0, rem = 0;
        do{
            rem = x % y;
            x = y;
            y = rem;
        }
        while (rem != 0);
        return x;
    }
}