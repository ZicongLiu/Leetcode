public class Solution {
    public int minCut(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        int cut[] = new int[s.length()];
        isPal[0][0] = true;
        cut[0] = 0;
        for (int i = 0 ; i < s.length() ; i++){
            cut[i] = i;
            for (int j = 0 ; j <= i ; j ++){
                if (s.charAt(i) == s.charAt(j)
                 && (i - j <= 1 || isPal[j + 1][i - 1])){
                    isPal[j][i] = true;
                    if (j == 0)
                        // no need to cut
                        cut[i] = 0;
                    else
                        cut[i] = Math.min(cut[i] , cut[j - 1] + 1);
                }
                
            }
        }
        
        return cut[s.length() - 1];
    }
}