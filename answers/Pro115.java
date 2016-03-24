public class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0 ; i <= lenS ; i++){
            dp[i][0] = 1;
        }
        for (int j = 1 ; j <= lenT ; j++){
            for (int i = 1 ; i <= lenS ; i++){
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }
}