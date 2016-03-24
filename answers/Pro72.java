public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] minDis = new int[word1.length() + 1][word2.length() + 1];
        
        for (int idx1 = 0 ; idx1 <= word1.length() ; idx1 ++){
            minDis[idx1][0] = idx1;
        }
        for (int idx2 = 0 ; idx2 <= word2.length() ; idx2 ++){
            minDis[0][idx2] = idx2;
        }
        for (int idx1 = 1 ; idx1 <= word1.length() ; idx1 ++){
            for (int idx2 = 1 ; idx2 <= word2.length() ; idx2 ++){
                int diff = 0;
                if (word1.charAt(idx1 - 1) != word2.charAt(idx2 - 1)){
                    diff = 1;
                }
                minDis[idx1][idx2] = Math.min(minDis[idx1 - 1][idx2 - 1]
                 + diff, Math.min(minDis[idx1 - 1][idx2] + 1
                  , minDis[idx1][idx2 - 1] + 1));
            }
        }
        
        return minDis[word1.length()][word2.length()];
    }
}