public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[start] == nums[mid] && nums[start] > nums[start + 1]){
                return nums[start + 1];
            }
            else{
                if (nums[start] < nums[mid]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        
        return nums[0];
    }
}