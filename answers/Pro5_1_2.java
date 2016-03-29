//initialization:
//dp[i][i]=true
//if(s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = true

//other situation:
// if(s[i]==s[j])
// 	dp[i][j] = dp[i+1][j-1];
// else
// 	dp[i][j] = false;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int max = 0;
        int start = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        for(int i = n - 1; i >= 0; i-- ){ // mind the for loop
            for (int j = i ; j < n; j++ ){
                if(s.charAt(j) == s.charAt(i) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j-i+1 > max){
                        max = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
}