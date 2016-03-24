public class Solution {
    public boolean isNumber(String s) {
        int idx = 0; 
        // skip spaces in the front
        while(idx < s.length() && s.charAt(idx) == ' '){
            idx ++;
        }
        
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')){
            idx ++;
        }
        boolean isNumeric = false;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))){
            isNumeric = true;
            idx ++;
        }
        
        if (idx < s.length() && s.charAt(idx) == '.'){
            idx ++;
            while (idx < s.length() && Character.isDigit(s.charAt(idx))){
                isNumeric = true;
                idx ++;
            }
        }
        
        if (idx < s.length() && isNumeric && (s.charAt(idx) == 'e'
         || s.charAt(idx) == 'E')){
            idx ++;
            isNumeric = false;
            if (idx < s.length() && (s.charAt(idx) == '+'
             || s.charAt(idx) == '-')){
                idx ++;
            }
            
            while (idx < s.length() && Character.isDigit(s.charAt(idx))){
                isNumeric = true;
                idx ++;
            }
        }
        
        // skip spaces in the end
        while (idx < s.length() && s.charAt(idx) == ' '){
            idx ++;
        }
        
        return isNumeric && idx == s.length();        
    }
}