public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int idx = s.length() - 2; idx >= 0 ; idx --){
            if (s.charAt(idx) == '('){
                int nextIdx = idx + dp[idx + 1] + 1;
                if (nextIdx >= s.length()){
                    continue;
                }
                if (s.charAt(nextIdx) == ')'){
                    dp[idx] = dp[idx + 1] + 2;
                    if (nextIdx + 1 <= s.length() - 1
                     && s.charAt(nextIdx + 1) == '('){
                        dp[idx] += dp[nextIdx + 1];
                    }
                    if (dp[idx] > max){
                        max = dp[idx];
                    }
                }
            }
        }
        return max;
    }
}