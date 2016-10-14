public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        Arrays.fill(count , 0);
        char[] chArr = s.toCharArray();
        for (char ch : chArr){
            if (ch > 'Z')
                count[ch - 'a' + 26] ++;
            else
                count[ch - 'A'] ++;
        }
        int sum = 0;
        boolean hasOdd = false;
        for (int i = 0 ; i < 52 ; i++){
            if (count[i] % 2 == 1)
                hasOdd = true;
            sum += count[i] / 2 * 2;
        }
        if (hasOdd)
            sum ++;
        return sum;
    }
}