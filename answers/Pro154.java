public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int start = 0 , end = nums.length - 1;
        while (start < end){
            // this is weird since we should always consider the condition
            // that a[l] > a[r]
            if (nums[start] < nums[end]){
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (mid == start){
                if (nums[start] > nums[start + 1]){
                    return nums[start + 1];
                }
            }
            if (nums[start] > nums[mid]){
                end = mid;
            } else if (nums[end] < nums[mid]){
                start = mid;
            } else{
                start ++;
            }
        }
        return nums[0];
    }
}