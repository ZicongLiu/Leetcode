public class MedianFinder {
    static final int MAX_LEN = 100000;
    int[] nums = new int[MAX_LEN];
    int length = 0;
    // Adds a number into the data structure.
    public void addNum(int num) {
        nums[length ++] = num;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (length % 2 == 0){
            return (partition(nums, 0, length - 1, length / 2 - 1)
             + partition(nums, 0, length - 1, length / 2)) / 2;
        }
        else{
            return partition(nums, 0, length - 1, length / 2);
        }
        
    }
    
    private double partition(int[] nums, int start, int end, int target){
//      if (start > end){
//          return -1;
//      }
        int pivot = nums[start];
        int low = start, high = end;
        while (start < end){
            while (start < end && nums[end] >= pivot){
                end --;
            }   
            nums[start] = nums[end];
            
            while (start < end && nums[start] <= pivot){
                start ++;
            }   
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        if (start == target){
            return pivot;
        }
        else if (start > target){
            return partition(nums, low, start - 1, target);
        }
        else{
            return partition(nums, start + 1, high, target);
        }
        
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();