public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;  
        while(m != n) {  
            m >>= 1;  
            n >>= 1;  
            bit ++;  
        }  
        return m << bit;  
    }
}

// OR


public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((mask&m)!=(mask&n)){
            mask=mask<<1;
        }
        return mask&m;
    }
}