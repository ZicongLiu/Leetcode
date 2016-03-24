public class Solution {
    private int wiggleIndex(int idx , int length){
        return (2 * idx + 1) % (length | 1);
    }
    
    private int partitionMedian(int[] nums){
        int low = 0 , high = nums.length - 1, targetIdx = nums.length / 2;
        
        while(true){
            int pivotIdx = -1;
            int pivot = nums[low];
            int start = low, end = high;
            
            while (low < high){
                while (low < high && nums[high] <= pivot){
                    high --;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] >= pivot){
                    low ++;
                }
                nums[high] = nums[low];
            }
            if (low == high){
                pivotIdx = low;
            }
            nums[pivotIdx] = pivot;
            if (pivotIdx == targetIdx){
                return pivot;
            }
            
            if (pivotIdx > targetIdx){
                high = pivotIdx - 1;    
                low = start;
            }
            else{
                low = pivotIdx + 1;
                high = end;
            }
        }
    }
    
    public void wiggleSort(int[] nums) {
        int median = partitionMedian(nums);
        int current = 0, low = nums.length - 1, high = 0;
        while (current <= low){
            if (nums[wiggleIndex(current, nums.length)] == median){
                current ++;
            }
            else if (nums[wiggleIndex(current, nums.length)] > median){
                int swap = nums[wiggleIndex(current, nums.length)];
                nums[wiggleIndex(current, nums.length)]
                     = nums[wiggleIndex(high, nums.length)];
                nums[wiggleIndex(high, nums.length)] = swap;
                high ++;
                current ++;
            }
            else{
                int swap = nums[wiggleIndex(current, nums.length)];
                nums[wiggleIndex(current, nums.length)]
                     = nums[wiggleIndex(low, nums.length)];
                nums[wiggleIndex(low, nums.length)] = swap;
                low--;
            }
        }
    }
}