public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] products = new int[nums.length];
        products[0] = 1;
        for (int idx = 1 ; idx < nums.length ; idx++){
            products[idx] = products[idx - 1] * nums[idx - 1];
        }
        
        int product = 1;
        for (int idx = nums.length - 2 ;  idx >= 0 ; idx --){
            product *= nums[idx + 1];
            products[idx] *= product;
        }
        
        return products;
    }
}