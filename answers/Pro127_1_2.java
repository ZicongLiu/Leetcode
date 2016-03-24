public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {  
        Set<String> sourceSet = new HashSet<String>();
        Set<String> targetSet = new HashSet<String>();
        sourceSet.add(start);
        targetSet.add(end);
        return findLadder(sourceSet, targetSet, dict, 1);
    }
    
    private int findLadder(Set<String> sourceSet, Set<String> targetSet, Set<String> dict, int depth){
        if (sourceSet.size() == 0){
            return 0;
        }
        if (targetSet.size() < sourceSet.size()){
            return findLadder(targetSet, sourceSet, dict, depth);
        }
        for (String s : sourceSet){
            dict.remove(s);
        }
        for (String s : targetSet){
            dict.remove(s);
        }
        Set<String> newSet = new HashSet<String>();
        for (String source : sourceSet){
            for (int strIdx = 0 ; strIdx < source.length() ; strIdx ++){
                // If I put
                //  char[] sourceCharArr = source.toCharArray();
                // here, I will get TLE?!
                for (char subChar = 'a' ; subChar <= 'z' ; subChar ++){
                    if (source.charAt(strIdx) == subChar){
                        continue;
                    }
                    // This statement...
                    char[] sourceCharArr = source.toCharArray();
                    sourceCharArr[strIdx] = subChar;                    
                    String newSource = new String(sourceCharArr);
                    for (String target : targetSet){
                        if (target.equals(newSource)){
                            return depth + 1;    
                        }
                    }
                    if (dict.contains(newSource)){
                        newSet.add(newSource);                        
                    }
                }
            }
        }
        return findLadder(newSet, targetSet, dict, depth + 1);
    }
}