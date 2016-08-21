public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[257];
        char[] magChars = magazine.toCharArray();
        for (char magCh : magChars){
            letters[magCh] ++;
        }
        char[] ransomChars = ransomNote.toCharArray();
        for (char ransomCh : ransomChars){
            if (letters[ransomCh] == 0){
                return false;
            }
            else{
                letters[ransomCh] --;
            }
        }
        
        return true;
    }
}