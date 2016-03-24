public class Solution {
    public boolean isScramble(String s1, String s2) {
       boolean dp[][][] = new boolean[s1.length() + 1][s1.length()][s1.length()];
       for (int i = 0 ; i < s1.length() ; i ++){
           for (int j = 0 ; j < s1.length() ; j ++){
               dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));
           }
       }

       for (int k = 1 ; k <= s1.length() ; k ++){
           for (int i = 0 ; i <= s1.length() - k ; i ++){
               for (int j = 0 ; j <= s1.length() - k ; j++){
                   for (int inner = 1 ; inner < k ; inner ++){
                       dp[k][i][j] |= dp[inner][i][j] && dp[k - inner][i + inner][j + inner];
                       dp[k][i][j] |= dp[inner][i][j + k - inner] && dp[k - inner][i + inner][j];
                       if (dp[k][i][j]){
                           break;
                       }
                   }
               }
           }
       }
       return dp[s1.length()][0][0];
    }
}