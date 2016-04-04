public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }
        // former solution, much more slower than saved array
        // int num1 = 0, num2 = 0;
        // for (int i = 0 ; i < s1.length() ; i++){
        //     num1 |= (1 << (s1.charAt(i) - 'a'));
        //     num2 |= (1 << (s2.charAt(i) - 'a'));
        // }
        // if (num1 != num2){
        //     return false;
        // }
        int[] saved = new int[26];
        for(int idx = 0 ; idx < s1.length() ; idx++){
            saved[s1.charAt(idx)-'a'] += 1;
            saved[s2.charAt(idx)-'a'] -= 1;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(saved[i] != 0) return false;
        }
        
        boolean result = false;
        for (int i = 1 ; i < s1.length() ; i ++){
            String left1 = s1.substring(0, i), right1 = s1.substring(i);
            String left2 = s2.substring(0, i), right2 = s2.substring(i);
            String left2Rev = s2.substring(0, s1.length() - i),
                   right2Rev = s2.substring(s1.length() - i);
            result |= (isScramble(left1, left2) && isScramble(right1, right2))
             || (isScramble(left1, right2Rev) && isScramble(right1, left2Rev));
            if (result == true){
                return result;
            }
        }
        return result;
    }
}