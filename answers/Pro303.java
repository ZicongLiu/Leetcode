public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int sum = 0;
        for (int idx = 0 ; idx < nums.length ; idx ++){
            sum += nums[idx];
            sums[idx] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0){
            return sums[j];
        }
        else{
            return sums[j] - sums[i - 1];    
        }
        
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);