public class Solution {
    public int firstUniqChar(String s) {
        int[] appearances = new int[26];
        for (int aIdx = 0 ; aIdx < 26; aIdx ++){
            appearances[aIdx] = -1;
        }
        for (int idx = 0 ; idx < s.length() ; idx ++){
            int letterIdx = s.charAt(idx) - 'a';
            if (appearances[letterIdx] == -1){
                appearances[letterIdx] = idx;
            }
            else if (appearances[letterIdx] >= 0){
                appearances[letterIdx] = -2;
            }
        }
        int minIdx = Integer.MAX_VALUE;
        for (int aIdx = 0 ; aIdx < 26 ; aIdx ++){
            if (appearances[aIdx] >= 0){
                minIdx = Math.min(appearances[aIdx], minIdx);
            }
        }
        return (minIdx == Integer.MAX_VALUE) ? -1 : minIdx;
    }
}