public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < 32 ; i ++){
            int digit = 0;
            int mask = (1 << i);
            for(int idx = 0 ; idx < nums.length ; idx ++){
                if ((nums[idx] & mask) != 0){
                    digit ++;
                }
            }
            if (digit % 3 != 0){
                result |= mask;
            }
        }
        return result;
    }
}