public class Solution {
    public char findTheDifference(String s, String t) {
        int count[] = new int[26];
        char[] arr = s.toCharArray();
        for (char ch : arr){
            count[ch - 'a']++;
        }
        arr = t.toCharArray();
        for (char ch : arr){
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0){
                return ch;
            }
        }
        return 'a';
    }
}