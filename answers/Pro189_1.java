public class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        k = k % nums.length;
        for (int i = nums.length - k ; i < nums.length ; i++){
            result[i - nums.length + k] = nums[i];
        }
        for (int j = 0 ; j < nums.length - k ; j ++){
            result[k + j] = nums[j];
        }
        for (int i = 0 ; i < nums.length ; i ++){
            nums[i] = result[i];
        }
    }
}