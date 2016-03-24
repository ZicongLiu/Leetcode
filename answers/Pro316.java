public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0)
            return "";
        int[] count = new int[26];
        for (int i = 0 ; i < s.length() ; i ++)
            count[s.charAt(i) - 'a'] ++;
        char minChar = 'z';
        int minPos = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if (minChar > s.charAt(i)){
                minPos = i;
                minChar = s.charAt(i);
            }
            count[s.charAt(i) - 'a'] --;
            if (count[s.charAt(i) - 'a'] == 0)
                break;
        }
        return minChar + removeDuplicateLetters(
            s.substring(minPos + 1).replaceAll("" + minChar, ""));
        
    }
}