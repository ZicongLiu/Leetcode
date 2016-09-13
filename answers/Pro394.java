public class Solution {
    public String decodeString(String s) {
        Stack<String> numbers = new Stack<String>();
        Stack<String> patterns = new Stack<String>();
        Stack<Integer> levels = new Stack<Integer>();
        int curLevel = 0;
        String curNumber = "";
        String curPattern = "";
        char[] arr = s.toCharArray();
        for (int idx = 0 ; idx < arr.length ; idx ++){
            if (arr[idx] >= '0' && arr[idx] <= '9'){
                curNumber = curNumber + arr[idx];
                if (curPattern.length() > 0){
                    patterns.push(curPattern);
                    levels.push(curLevel);
                    curPattern = "";
                }
            }
            else if ((arr[idx] >= 'a' && arr[idx] <= 'z') ||
                     (arr[idx] >= 'A' && arr[idx] <= 'Z')){
                curPattern = curPattern + arr[idx];
                if (curNumber.length() > 0){
                    numbers.push(curNumber);
                    curNumber = "";
                }
                 
            }
            else if (arr[idx] == '['){
                if (curNumber.length() > 0){
                    numbers.push(curNumber);
                }
                curNumber = "";
                curPattern = "";
                curLevel ++;
            }
            else {
                if (curPattern.length() > 0){
                    patterns.push(curPattern);   
                    levels.push(curLevel);
                }
                String topPattern = patterns.pop();
                int peekLevel = levels.pop();
                int num = Integer.parseInt(numbers.pop());
                // System.out.println(num + " * " + topPattern);
                String pattern = "";

                while (patterns.size() > 0 && levels.peek() == peekLevel){
                    topPattern = patterns.pop() + topPattern;
                    levels.pop();
                }
                for (int i = 0 ; i < num ; i ++){
                    pattern = pattern + topPattern;
                }
                curLevel --;
                patterns.push(pattern);
                levels.push(curLevel);
                curNumber = "";
                curPattern = "";
            }
        }
        if (curPattern.length() > 0){
            patterns.push(curPattern);
            levels.push(curLevel);
        }
        String result = "";
        while (patterns.size() > 0){
            result = patterns.pop() + result;
        }
        return result;
    }
}