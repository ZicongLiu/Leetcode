public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int idx = len - 1;
        int count = 0;
        while (idx >= 0){
            // skip spaces in the end
            while (idx >= 0 && s.charAt(idx) == ' '){
                idx --;
            }
            if (idx < 0){
                return 0;
            }
            while (idx >= 0 && s.charAt(idx) != ' '){
                count ++;
                idx --;
            }
            break;
        }
        return count;
    }
}