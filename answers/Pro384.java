public class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = Arrays.copyOf(nums, nums.length);
        for (int idx = 1; idx < result.length ; idx ++){
            int swapIdx = new Random().nextInt(idx + 1);
            
            int swap = result[swapIdx];
            result[swapIdx] = result[idx];
            result[idx] = swap;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */