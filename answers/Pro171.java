public class Solution {
    public int titleToNumber(String s) {
        char[] title = s.toCharArray();
        int sum = 0;
        
        for (int idx = 0 ; idx < title.length ; idx++){
            char c = title[idx];
            int digit = c - 'A' + 1;
            
            sum = sum * 26 + digit;
        }
        
        return sum;
    }
}