public class Solution {
    public int maxProduct(String[] words) {
        int[] bitMap = new int[words.length];
        for (int idx = 0 ; idx < words.length; idx ++){
            String word = words[idx];
            for(int strIdx = 0 ; strIdx < word.length() ; strIdx ++){
                char curChar = word.charAt(strIdx);
                bitMap[idx] |= 1 << curChar - 'a';
            }
        }
        int max = 0;
        for (int i = 0 ; i < words.length ; i++){
            for (int j = i + 1 ; j < words.length ; j ++){
                if ((bitMap[i] & bitMap[j]) == 0){
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}