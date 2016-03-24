public class Solution {
    public boolean isMatch(String s, String p) {
        for(int i = 0; i < p.length(); s = s.substring(1)) {
            char c = p.charAt(i);
            if(i + 1 >= p.length() || p.charAt(i + 1) != '*')
                i++;
            else if(isMatch(s, p.substring(i + 2)))
                return true;

            if(s.isEmpty() || (c != '.' && c != s.charAt(0)))
                return false;
        }

        return s.isEmpty();
    }
}