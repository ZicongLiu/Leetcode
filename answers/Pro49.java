public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> anagramGroups
         = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        
        for (String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            
            
            List<String> anaList = new ArrayList<String>();
            if (anagramGroups.containsKey(sortedString)){
                anaList = anagramGroups.get(sortedString);
            }
            
            anaList.add(str);
            anagramGroups.put(sortedString, anaList);
        }
        Set<String> anagramKeySet = anagramGroups.keySet();
        for (String anagramKey : anagramKeySet){
            result.add(anagramGroups.get(anagramKey));
        }
        
        return result;
    }
}