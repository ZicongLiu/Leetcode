public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 1 , j = nums.length;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (hasWindow(nums, mid,s)){
                min = Math.min(min, mid);
                j = mid - 1;
            }
            else{
                i = mid + 1;                
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public boolean hasWindow(int[] nums, int curLen, int s){
        int sum = 0;
        for (int i = 0 ;i < nums.length ; i++){
            if (i >= curLen){
                sum -= nums[i - curLen];
            }
            sum += nums[i];
            if (sum >= s){
                return true;
            }
        }
        return false;
    }

}