public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        String result = "";
        Stack<Integer> stack = new Stack<Integer>();
        char[] numArr = num.toCharArray();
        for (int numIdx = 0; numIdx < num.length(); numIdx++) {
            int n = numArr[numIdx] - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        int diff = (stack.size() > num.length() - k) ? stack.size()
                - (num.length() - k) : 0;
        while (diff > 0) {
            diff--;
            stack.pop();
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            result = cur + result;
        }
        // Remove leading zeros
        char[] resultArr = result.toCharArray();
        int resultIdx = 0;
        while (resultIdx < resultArr.length
             && resultArr[resultIdx] == '0'){
            resultIdx ++;
        }
        if (resultIdx == resultArr.length){
            return "0";
        }
        else{
            return new String(resultArr, resultIdx,
             resultArr.length - resultIdx);
        }
    }
}