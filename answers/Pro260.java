public class Solution {
    public int[] singleNumber(int[] nums) {
        int total = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums){
            total ^= num;
        }
        int mDigit = -1;
        for (int i = 0 ; i < 32 ; i++){
            int mask = (1 << i);
            if ((total & mask) != 0){
                // find the digit
                mDigit = i;
                for (int j = 0 ; j < nums.length ; j++){
                    if ((nums[j] & mask) != 0){
                        count1 ++;
                    }
                    else{
                        count2 ++;
                    }
                }
                
                break;
            }
        }
        int[] g1 = new int[count1];
        int[] g2 = new int[count2];
        int idx1 = 0 , idx2 = 0;
        int mask = (1 << mDigit);
        for (int i = 0 ; i < nums.length ; i ++){
            if ((nums[i] & mask) != 0){
                g1[idx1] = nums[i];
                idx1 ++;
            }else{
                g2[idx2] = nums[i];
                idx2 ++;
            }
        }
        int num1 = 0 , num2 = 0;
        for (int num : g1){
            num1 ^= num;
        }
        for (int num : g2){
            num2 ^= num;
        }
        int[] result = new int[2];
        result[0] = num1;
        result[1] = num2;
        return result;
    }
}