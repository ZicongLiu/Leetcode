public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3){
            return false;
        }
        int len = 1;
        int smaller = nums[0];
        int larger = -1;
        
        for (int idx = 1 ; idx < nums.length ; idx ++){
            if (nums[idx] < smaller){
                smaller = nums[idx];
            }
            else if (nums[idx] > smaller){
                if (len == 1){
                    larger = nums[idx];
                    len++;
                }
                if (len == 2){
                    if (nums[idx] > larger){
                        return true;
                    }
                    else{
                        larger = nums[idx];
                    }
                }
            }
        }
        return false;
    }
}