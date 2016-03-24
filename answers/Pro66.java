public class Solution {
    public int[] plusOne(int[] digits){
        for (int idx = digits.length - 1 ; idx >= 0 ; idx--){
            int digit = digits[idx];
            if (digit < 9){
                digits[idx] = digit + 1;
                return digits;
            }
            else{
                digits[idx] = 0;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (int idx = 0 ; idx < digits.length ; idx ++){
            newDigits[idx + 1] = 0;
        }
        return newDigits;
    }
}