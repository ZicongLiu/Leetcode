public class Solution {
    private int partition(int[] nums, int low, int high){
        if (low == high){
            return low;
        }
        int i = low;
        int j = high;
        int pivot = nums[i];
        while (i < j ){
            while (i < j && nums[j] >= pivot){
                j--;
            }
            // actually, this is not needed
            if (i == j){
                break;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= pivot){
                i ++;
            }
            // actually, this is not needed
            if (i == j){
                break;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
    
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k || k == 0){
            return -1;
        }
        k = nums.length - k;
        int low = 0 , high = nums.length - 1;
        int pivotIdx = partition(nums, low, high);
        while(low < high && pivotIdx != k){
            if (pivotIdx > k){
                high = pivotIdx - 1;
            }
            else{
                low = pivotIdx + 1;
            }
            
            pivotIdx = partition(nums, low, high);
        }
        return nums[pivotIdx];
    }
}