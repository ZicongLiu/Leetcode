public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j){
            while (i < s.length() && !Character.isLetter(s.charAt(i)) 
                && !Character.isDigit(s.charAt(i))){
                i ++;
            }
            while (j > 0 && !Character.isLetter(s.charAt(j))
                && !Character.isDigit(s.charAt(j))){
                j --;
            }
            if (i >= j){
                return true;
            }

            if (Character.toLowerCase(s.charAt(i)) !=
                 Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}