public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<Character>();
        set.add('A');set.add('a');
        set.add('E');set.add('e');
        set.add('I');set.add('i');
        set.add('O');set.add('o');
        set.add('U');set.add('u');
        char[] charArr = s.toCharArray();
        int i = 0 , j = s.length() - 1;
        while(i < j){
            while (i < j && !(set.contains(s.charAt(i)))){
                i++;
            }
            while (i < j && !(set.contains(s.charAt(j)))){
                j--;
            }
            if (i >= j){
                break;
            }
            char tmp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = tmp;
            i++;
            j--;
        }
        
        return new String(charArr);
    }
}