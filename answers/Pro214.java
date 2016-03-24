public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        String revS = new StringBuilder(s).reverse().toString();
        String longStr = s + "#" + revS;
        int patternIdx = 0;
        int[] next = new int[longStr.length()];
        next[0] = 0;
        for (int strIdx = 1 ; strIdx < longStr.length() ; strIdx ++){
            while (patternIdx > 0 && longStr.charAt(strIdx)
                 != longStr.charAt(patternIdx)){
                patternIdx = next[patternIdx - 1];
            }
            if (longStr.charAt(strIdx) == longStr.charAt(patternIdx)){
                patternIdx ++;
            }
            next[strIdx] = patternIdx;
            // System.out.println(strIdx + " : " + patternIdx);
        }
        return revS.substring(0, revS.length() - next[longStr.length() - 1]) + s;
    }
}