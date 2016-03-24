public class Solution {
    List<String> result = new ArrayList<String>();
    private void findWordCombinations(List<String> curResult, int endIdx,
     String s, List<String>[] wordSnippets){
        if (endIdx > s.length()){
            return;
        }
        if (endIdx == 0){
            String combine = "";
            for (int wordIdx = curResult.size() - 1 ;
                     wordIdx >= 0 ; wordIdx --){
                combine += curResult.get(wordIdx);
                if (wordIdx != 0){
                    combine += " ";   
                }
            }
            result.add(combine);
            return;
        }
        if (wordSnippets[endIdx] == null){
            return;
        }
        for (String word : wordSnippets[endIdx]){
            curResult.add(word);
            findWordCombinations(curResult, endIdx - word.length()
             , s, wordSnippets);
            curResult.remove(curResult.size() - 1);
        }
    }
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] wordSnippets = new ArrayList[s.length() + 1];
        wordSnippets[0] = new ArrayList<String>();
        for (int i = 0 ; i < s.length() ; i ++){
            if (wordSnippets[i] != null){
                // Should have a precessor
                for (String word : wordDict){
                    int wordLen = word.length();
                    if (wordLen + i <= s.length()){
                        String part = s.substring(i, i + wordLen);
                        if (part.equals(word)){
                            if (i + wordLen > s.length()){
                                continue;
                            }
                            if (wordSnippets[i + wordLen] == null){
                                wordSnippets[i + wordLen] 
                                = new ArrayList<String>();
                            } 
                            wordSnippets[i + wordLen].add(part);
                        }
                    }
                }
            }
        }
        findWordCombinations(new ArrayList<String>(), s.length() , s, wordSnippets);
        return result;
    }
}