public class Solution {
    public void sortColors(int[] nums) {
        int idxZero = 0 , idxTwo = nums.length - 1;
        int idx = 0;
        while (idx <= idxTwo){
            if (nums[idx] == 0){
                swap(nums, idx, idxZero);
                idx ++;
                idxZero ++;
            }
            else if (nums[idx] == 2){
                swap(nums, idx, idxTwo);
                // idx ++;
                idxTwo --;
            }
            else{
                idx ++;
            }
        }
    }
    
    public void swap(int[] nums, int idx1, int idx2){
        int swap = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = swap;
    }
}