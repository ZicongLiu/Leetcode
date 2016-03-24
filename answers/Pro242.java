public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[256];
        int[] countT = new int[256];
        Arrays.fill(countS, 0);
        Arrays.fill(countT, 0);
        if (s.length() != t.length()){
            return false;
        }
        for (int idxS = 0 ; idxS < s.length() ; idxS ++){
            char chS = s.charAt(idxS);
            countS[chS] ++;
        }
        for (int idxT = 0 ; idxT < t.length() ; idxT ++){
            char chT = t.charAt(idxT);
            countT[chT] ++;
        }
        for (int idx = 0 ; idx < 256 ; idx ++){
            if (countS[idx] != countT[idx]){
                return false;
            }
        }
        return true;
    }
}