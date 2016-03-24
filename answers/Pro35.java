public class Solution {
	public int searchInsert(int[] nums, int target) {
    	if (target <= nums[0]){
    		return 0;
    	}
    	if (target > nums[nums.length - 1]){
    		return nums.length;
    	}
        int l = 0 , r = nums.length - 1;
        while (l < r){
        	int mid = (l + r) / 2;
        	if (target == nums[mid]){
            	return mid;
            }
        	if (mid == l && target != nums[mid]){
                return mid + 1;
        	}
        	if (target > nums[mid]){
        		l = mid;
        	}
        	else{
        		r = mid;
        	}
        }
        return -1;
    }
}