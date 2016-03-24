public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()){
            return multiply(num2, num1);
        }
        
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        int[] numArr1 = new int[num1.length()];
        int[] numArr2 = new int[num2.length()];
        for (int idx = 0 ; idx < num1.length() ;idx ++){
            numArr1[idx] = num1.charAt(idx) - '0';
        }
        for (int idx = 0 ; idx < num2.length() ;idx ++){
            numArr2[idx] = num2.charAt(idx) - '0';
        }
        
        int[] result = new int[num1.length() + num2.length()];
        
        for (int num2Idx = num2.length() - 1 ; num2Idx >= 0 ; num2Idx --){
            int carry = 0;
            int resultCarry = 0;
            int endIdx = num2.length() - 1 - num2Idx;
            for (int num1Idx = num1.length() - 1 ; num1Idx >= 0 ; num1Idx --){
                int multiplyResult = numArr1[num1Idx] * numArr2[num2Idx];
                int digit = (multiplyResult + carry) % 10;
                carry = (multiplyResult + carry) / 10;
                int addResult = digit + result[endIdx];
                result[endIdx] = (addResult + resultCarry) % 10;
                resultCarry = (addResult + resultCarry) / 10;
                endIdx ++;
            }
            if (carry != 0 || resultCarry != 0){
                result[endIdx] += resultCarry + carry;
                if (result[endIdx] >= 10){
                    result[endIdx + 1] = result[endIdx];
                    result[endIdx] %= 10;
                }
            }
        }
        String finalResult = "";
        boolean firstDigit = false;
        for (int idx = result.length - 1; idx >= 0 ; idx --){
            if (!firstDigit && result[idx] != 0){
                firstDigit = true;
            }
            if (!firstDigit && result[idx] == 0){
                continue;
            }
            finalResult += String.valueOf(result[idx]);
        }
        
        return finalResult;
    }
}