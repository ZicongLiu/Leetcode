public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s;
        }
        int max = 0;
        int startIdx = -1;
        for (int i = 0 ; i < s.length() ; i ++){
            int singleMax = expandToSides(s, i, i);
            if (max < singleMax){
                max = singleMax;
                startIdx = i - max / 2;
            }
            if (i > 0){
                int doubleMax = expandToSides(s, i - 1, i);
                if (max < doubleMax){
                    max = doubleMax;
                    startIdx = i - max / 2;
                }
            }
        }
        return s.substring(startIdx, startIdx + max);
    }
    public int expandToSides(String s, int left, int right){
        int start = left, end = right;
        int max = 0;
        while (start >= 0 && end < s.length()){
            if (s.charAt(start) == s.charAt(end)){
                max = Math.max(end - start + 1, max);
            }
            else{
                break;
            }
            start --;
            end ++;
        }
        return max;
    }
}