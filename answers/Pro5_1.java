public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1){
            return s;
        }
        int[][] dp = new int[len][len];
        int max = 1;
        int startIdx = -1;
        for (int i = 0 ; i < len ; i ++){
            dp[i][i] = 1;
            if (max == 1){
                startIdx = i;
            }
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)){
                dp[i - 1][i] = 2;
                max = 2;
                startIdx = i - 1;
            }
        }
        for (int subLen = 3 ; subLen <= len  ; subLen ++){
            for (int i = 0 ; i < len - subLen + 1 ; i ++){
                int j = i + subLen - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0){
                    dp[i][j] = Math.max(dp[i][j] , dp[i + 1][j - 1] + 2);
                    if (max < dp[i][j]){
                        max = dp[i][j];
                        startIdx = i;
                    }
                }
            }
        }
        return s.substring(startIdx, startIdx + max);
    }
}