public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = find(nums, target, false);
        int right = find(nums, target, true);
        result[0] = left;
        result[1] = right;
        return result;
    }
    
    private int find(int[] nums, int target, boolean forward){
        int start = 0 , end = nums.length - 1;
        
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                if (forward){
                    if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]){
                        return mid;
                    }
                    else{
                        start = mid + 1;
                    }
                }else{
                    if (mid == 0 || nums[mid - 1] < nums[mid]){
                        return mid;
                    }
                    else{
                        end = mid - 1;
                    }
                }
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}