public class Solution {
    public boolean isPowerOfTwo(int n) {
    	if (n <= 0){
    		return false;
    	}
        int cur = (int)n - 1;
        while (cur != 0){
        	if ((cur & 1) != 1){
        		return false;
        	}
        	cur = (cur >> 1);
        }
        return true;
    }
}