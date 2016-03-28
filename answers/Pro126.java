public class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> findLadders(String beginWord, String endWord,
                                         Set<String> wordList) {  
        Map<String, List<String>> succs = new HashMap<String, List<String>>();
        Set<String> beginWords = new HashSet<String>();
        Set<String> endWords = new HashSet<String>();
        beginWords.add(beginWord);
        endWords.add(endWord);
        bfsLadders(beginWords, endWords, wordList, succs, false);
        
        List<String> pathStarts = new ArrayList<String>();
        pathStarts.add(beginWord);
        buildPath(beginWord, endWord, succs, new ArrayList(pathStarts));
        return result;
    }  
    private void bfsLadders(Set<String> beginWords, Set<String> endWords,
         Set<String> dict, Map<String, List<String>> succs, boolean reversed){
        
        if (beginWords.isEmpty()){
        	return;
        }
        if (beginWords.size() > endWords.size()){
            bfsLadders(endWords, beginWords, dict, succs, !reversed);
            return;
        }
        for (String beginWord : beginWords){
            dict.remove(beginWord);
        }
        for (String endWord : endWords){
            dict.remove(endWord);
        }
        Set<String> generated = new HashSet<String>();
        boolean found = false;
        for (String beginWord : beginWords){
            for (int strIdx = 0 ; strIdx < beginWord.length() ; strIdx ++){
                char[] wordCharArr = beginWord.toCharArray();
                for (char subChar = 'a' ; subChar <= 'z' ; subChar ++){
                    // Don't add this!
                    // if (wordCharArr[strIdx] == subChar){
                    //     continue;
                    // }
                    wordCharArr[strIdx] = subChar;
                    String newStr = new String(wordCharArr);
                    String key = reversed ? newStr : beginWord;
                    String value = reversed ? beginWord : newStr;
                    List<String> list = succs.containsKey(key) ?
                             succs.get(key) : new ArrayList<String>();
                    
                    if (endWords.contains(newStr)){
                            found = true;
                            
                            list.add(value);
                            succs.put(key, list);
                    }
                    else{
                        if (!dict.contains(newStr)){
                            continue;
                        }
                        else{
                            if (!found){
                                generated.add(newStr);
                                
                                list.add(value);
                                succs.put(key, list);
                            }
                        }
                    }
                }
            }
        }
        
        if (found){
            return;
        }
        bfsLadders(generated, endWords, dict, succs, reversed);
    }
    
    private void buildPath(String beginWord, String endWord,
             Map<String, List<String>> succs, List<String> curList){
        if (beginWord.equals(endWord)){
            result.add(new ArrayList(curList));
            return;
        }
        
        if (!succs.containsKey(beginWord)){
            return;
        }
        
        for (String next : succs.get(beginWord)){
            curList.add(next);
            buildPath(next, endWord, succs, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
