public class MedianFinder {
    static final int MAX_LEN = 100000;
    int[] nums = new int[MAX_LEN];
    int length = 0;
    // Adds a number into the data structure.
    public void addNum(int num) {
        int pos = 0;
        for (int idx = length - 1 ; idx >= 0 ; idx --){
            if (nums[idx] > num){
                nums[idx + 1] = nums[idx];
            }
            else{
                pos = idx + 1;
                break;
            }
        }
        nums[pos] = num;
        length ++;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (length % 2 == 1){
            return nums[length / 2] * 1.0;
        }
        else{
            return (nums[length / 2 - 1] + nums[length / 2]) * 1.0 / 2;
        }
    }    
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();