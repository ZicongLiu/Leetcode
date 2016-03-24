public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) <= 26
             && Integer.parseInt(s.substring(0, 2)) >= 10){
            if (Integer.parseInt(s.substring(0, 2)) % 10 == 0)
                dp[1] = 1;
            else
                dp[1] = 2;
        }
        else{
            if (Integer.parseInt(s.substring(0, 2)) % 10 == 0)
                dp[1] = 0;
            else
                dp[1] = 1;
        }
        
        for (int idx = 2; idx < s.length() ; idx ++){
            int singleDigit = Integer.parseInt(s.substring(idx , idx + 1));
            int doubleDigits = Integer.parseInt(s.substring(idx - 1 , idx + 1));
            if (singleDigit != 0){
                dp[idx] += dp[idx - 1];
            }
            if ((doubleDigits >= 10) && (doubleDigits <= 26)){
                dp[idx] += dp[idx - 2];
            }
        }
        
        return dp[s.length() - 1];
    }
}