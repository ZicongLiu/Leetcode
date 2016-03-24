public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = new String[26];
        String[] parts = str.split(" ");
        if (parts.length != pattern.length()){
            return false;
        }
        Set<String> strOcc = new HashSet<String>();
        for (int i = 0 ; i < 26 ; i++){
            strs[i] = "";
        }
        for (int idx = 0 ; idx < pattern.length() ; idx ++){
            int curOffset = pattern.charAt(idx) - 'a';
            if (strs[curOffset].length() == 0){
                if (strOcc.contains(parts[idx]))
                    return false;
                else
                    strOcc.add(parts[idx]);
                strs[curOffset] = parts[idx];
                continue;
            }
            else{
                if (!strs[curOffset].equals(parts[idx]))
                    return false;
            }
        }
        return true;
    }
}