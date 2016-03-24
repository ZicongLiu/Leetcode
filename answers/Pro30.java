public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0){
            return new ArrayList<Integer>();
        }
        Map<String, Integer> mapping = new HashMap<String, Integer>();
        Map<String, Integer> current = new HashMap<String, Integer>();
        // words in 'words' array may be duplicate
        for (String word : words){
            if (mapping.containsKey(word)){
                mapping.put(word, mapping.get(word) + 1);
            }
            else{
                mapping.put(word, 1);
            }
        }
        int wordCnt = words.length;
        int wordLen = words[0].length();
        // Since words are of the same length, we split each substrings.
        for (int i = 0 ; i <= s.length() - wordCnt * wordLen; i ++){
            current.clear();
            int j = 0;
            for (j = 0 ; j < wordCnt ; j++){
                String substring = s.substring(i + j * wordLen,
                                 i + (j + 1) * wordLen);
                if (!mapping.containsKey(substring)){
                    break;
                }
                if (current.containsKey(substring)){
                    current.put(substring, current.get(substring) + 1);
                }
                else{
                    current.put(substring, 1);
                }
                if (current.get(substring) > mapping.get(substring)){
                    break;
                }
            }
            if (j == wordCnt){
                result.add(i);
            }
        }
        
        return result;
    }
}