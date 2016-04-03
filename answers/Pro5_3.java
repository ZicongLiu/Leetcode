public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 2){
            if (s.length() != 2 || s.charAt(1) == s.charAt(0)){
                return s;
            }
            else{
                return s.substring(0, 1);
            }
        }
        int maxLen = 1;
        String curStr = preprocess(s);
        int[] lens = new int[2 * curStr.length() + 1];
        int rightBound = 0;
        int mid = 1;
        for (int idx = 1 ; idx < lens.length ; idx ++){
            lens[idx] = (rightBound > idx)
             ? Math.min(lens[2 * mid - idx], rightBound - idx): 0;
            while (idx + lens[idx] < curStr.length() && idx - lens[idx] >= 0
                    && curStr.charAt(idx + lens[idx])
                     == curStr.charAt(idx - lens[idx])){
                lens[idx] ++;
            }
            if (idx + lens[idx] > rightBound){
                rightBound = idx + lens[idx];
                mid = idx;
            }
        }
        int maxPos = 0;
        for (int lenIdx = 0 ; lenIdx < lens.length ; lenIdx ++){
            int len = lens[lenIdx];
            if (maxLen < len - 1){
                maxLen = len - 1;
                maxPos = lenIdx;
            }
        }
        String result = s.substring((maxPos - maxLen)/2,
            maxLen + (maxPos - maxLen) / 2);
        return result;
    }
    
    private String preprocess(String curStr){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int idxCh = 0 ; idxCh < curStr.length() ; idxCh ++){
            sb.append(curStr.charAt(idxCh));
            sb.append("#");
        }
        return sb.toString();
    }
}