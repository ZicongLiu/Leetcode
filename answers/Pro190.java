public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int newNum = 0;        
        for (int i = 0 ; i < 32 ; i++){
            newNum = (newNum << 1);
            newNum += (n & 1);
            n = n >>> 1;
        }
        return newNum;
    }
}