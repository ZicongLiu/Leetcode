public class Solution {
    public void nextPermutation(int[] nums) {
        int preIdx = -1 , postIdx = -1;
        for (int i = 0 ; i < nums.length - 1 ; i ++){
            if (nums[i] < nums[i + 1]){
                preIdx = i;
            }
        }        
        if (preIdx < 0){
            reverse(nums , 0 , nums.length - 1);
            return;
        }
        for (int i = preIdx + 1; i < nums.length ; i ++){
            if (nums[preIdx] < nums[i]){
                postIdx = i;
            }
        }
        int tmp = nums[preIdx];
        nums[preIdx] = nums[postIdx];
        nums[postIdx] = tmp;
        reverse(nums, preIdx + 1, nums.length - 1);
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i ++;
            j --;
        }
    }
}