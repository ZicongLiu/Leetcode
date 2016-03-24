public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        dp[0][0] = true;
        for (int i = 0 ; i <= s1.length(); i ++){
            for (int j = 0; j <= s2.length() ; j ++){
                if (i > 0 && s1.charAt(i - 1)
                     == s3.charAt(i + j - 1) && dp[i - 1][j]){
                    dp[i][j] = true;
                }
                if (j > 0 && s2.charAt(j - 1)
                     == s3.charAt(i + j - 1) && dp[i][j - 1]){
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}