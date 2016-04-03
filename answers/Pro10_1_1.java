public class Solution {
    private boolean isMatch(String s, int idxS, String p, int idxP) {
        if (idxS < s.length() && idxP >= p.length()) {
            return false;
        }
        if (idxP == p.length() && idxS == s.length()) {
            return true;
        }

        if ((idxP < p.length() - 1) && p.charAt(idxP + 1) == '*') {
            if (idxS < s.length()
                    && (p.charAt(idxP) == s.charAt(idxS) || (p.charAt(idxP) == '.'))) {
                return isMatch(s, idxS + 1, p, idxP + 2)
                        || isMatch(s, idxS + 1, p, idxP)
                        || isMatch(s, idxS, p, idxP + 2);
            } else {
                return isMatch(s, idxS, p, idxP + 2);
            }
        }
        if (idxS < s.length()
                && (p.charAt(idxP) == '.' || s.charAt(idxS) == p.charAt(idxP))) {
            return isMatch(s, idxS + 1, p, idxP + 1);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        // if (s.length() == 0)
        return isMatch(s, 0, p, 0);
    }
}