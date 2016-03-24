public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0){
            return "";
        }
        int[] require = new int[256];
        boolean[] needLetter = new boolean[256];
        for (int i = 0 ; i < t.length() ; i ++){
            needLetter[t.charAt(i)] = true;
            require[t.charAt(i)] ++;
        }
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        int i = 0;
        int j = -1;
        while (i < s.length() && j < s.length()){
            if (count > 0){
                j ++;
                if (j >= s.length()){
                    break;
                }
                require[s.charAt(j)] --;
                if (needLetter[s.charAt(j)] && require[s.charAt(j)] >= 0){
                    count --;
                }
            }else{
                int curLength = j - i + 1;
                if (curLength < minLength){
                    minLength = curLength;
                    minStr = s.substring(i, j + 1);
                }
                require[s.charAt(i)] ++;
                if (needLetter[s.charAt(i)] && require[s.charAt(i)] > 0){
                    count ++;
                }
                i ++;  
            }
        }
        return minStr;
    }
}