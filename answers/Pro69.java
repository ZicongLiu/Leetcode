public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int start = 1;
        int end = x - 1;
        int mid = start + (end - start) / 2;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (mid  == x / mid){
                return mid;
            }
            else{
                if (mid > x / mid){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        if (mid > x / mid){
            return mid - 1;
        }
        else{
            return mid;
        }
    }
}