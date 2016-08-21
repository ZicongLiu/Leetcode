public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        int low = 1, high = num;
        int mid = low + (high - low) / 2;
        while (low <= high){
            int div = num / mid;
            if (mid == div){
                if (num % div == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(mid < div){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return false;
    }
}