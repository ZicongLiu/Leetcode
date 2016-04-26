public class Solution {
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int i = 0 , j = s.length() - 1;
        while(i < j){
            char tmp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = tmp;
            i++;
            j--;
        }
        
        return new String(charArr);
    }
}