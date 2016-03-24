public class NumArray {
    private int[] biTree;
    private int[] nums;
    
    private int lowbit(int x){
        return x & (-x);
    }
    public NumArray(int[] nums) {
        if (nums.length == 0){
            return;
        }
        this.nums = nums;
        biTree = new int[nums.length];
        biTree[0] = nums[0];
        for (int idx = 1 ; idx < nums.length ; idx ++){
            for (int j = idx - lowbit(idx) + 1; j <= idx ; j ++){
                biTree[idx] += nums[j];
            }
        }
    }
    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        while (i < nums.length){
            biTree[i] += diff;
            i += lowbit(i);
            if (i == 0){
                break;
            }
        }
    }
    
    private int getSum(int idx){
        int sum = 0;
        while (idx > 0){
            sum += biTree[idx];
            idx -= lowbit(idx);
        }
        sum += biTree[0];
        
        return sum;
    }
    public int sumRange(int i, int j) {
        if (i == 0){
            return getSum(j);
        }
        else{
            return getSum(j) - getSum(i - 1);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);