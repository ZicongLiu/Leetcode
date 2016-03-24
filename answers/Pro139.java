public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0 ; i < s.length() ; i ++){
            if (dp[i]){
                for (String word : wordDict){
                    if (i + word.length() <= s.length()){
                        String compare = s.substring(i, i + word.length());
                        if (compare.equals(word)){
                            dp[i + word.length()] = true;
                        }
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
}