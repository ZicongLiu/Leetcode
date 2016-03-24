public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int start = 0 , end = 0;
        int maxLength = 0;
        boolean exists[] = new boolean[256];
        Arrays.fill(exists, false);
        
        while (end < s.length()){
            // iterate to find duplicated element
            maxLength = Math.max(maxLength, end - start);
            if (start != end){
                if (!exists[s.charAt(end)]){
                    exists[s.charAt(end)] = true;
                    end ++;
                }
                else{
                    while (s.charAt(start) != s.charAt(end)){
                        exists[s.charAt(start)] = false;
                        start ++;
                    }
                    start ++;
                    end ++;
                }
            }else{
                exists[s.charAt(start)] = true;
                end ++;
            }
        }
        
        maxLength = Math.max(maxLength, s.length() - start);
        
        return maxLength;
    }
}