public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0){
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> reverseMap
         = new HashMap<Character, Character>();
        
        for (int idx = 0 ; idx < s.length() ; idx++){
            char charS = s.charAt(idx);
            char charT = t.charAt(idx);
            
            if (map.containsKey(charS)){
                char compare = map.get(charS);
                if (compare != charT){
                    return false;
                }
            }
            else{
                if (reverseMap.containsKey(charT)){
                    return false;
                }
                map.put(charS, charT);
                reverseMap.put(charT, charS);
            }
        }
        
        return true;
    }
}