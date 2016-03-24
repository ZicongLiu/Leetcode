public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        for (int hIdx = 0 ; hIdx < haystack.length() ; hIdx ++){
            if (haystack.length() - hIdx < needle.length()){
                return -1;
            }
            
            if (haystack.charAt(hIdx) == needle.charAt(0)){
                int hStart = hIdx;
                int nStart = 0;
                while (nStart < needle.length()
                    && haystack.charAt(hStart) == needle.charAt(nStart)){
                    hStart ++;
                    nStart ++;
                }
                if (nStart == needle.length()){
                    return hIdx;
                }
            }
        }
        
        return -1;
    }
}