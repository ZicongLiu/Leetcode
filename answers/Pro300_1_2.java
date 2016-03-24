public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int[] tails = new int[nums.length];
        int len = 0;
        tails[len ++] = nums[0];
        
        for (int idx = 1 ; idx < nums.length ; idx ++){
            if (nums[idx] < tails[0]){
                tails[0] = nums[idx];
            } else if (nums[idx] > tails[len - 1]){
                tails[len ++] = nums[idx];
            } else{
                int fitPos = binarySearch(tails, nums[idx], len);
                tails[fitPos] = nums[idx];
            }
        }
        
        return len;
    }
    
    private int binarySearch(int[] tails, int target, int curLen){
        int start = 0 , end  = curLen - 1;
        while (start < end){
            int mid = (end - start) / 2 + start;
            if (tails[mid] == target){
                return mid;
            }
            else if (tails[mid] > target){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        if (start == end){
            return start;
        }
        else{
            return (tails[start] > target) ? start : end;
        }
    }
}