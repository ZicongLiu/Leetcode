public class Solution {
    public String convertToTitle(int n) {
        char[] titleDigits = new char[26];
        char a = 'A';
        for (int idx = 0 ; idx < 26 ; idx ++){
            titleDigits[idx] = (char)(a + idx);
        }
        String result = "";
        int cur = n;
        int rem = -1;
        
        while (cur != 0){
            rem = (cur - 1) % 26;
            result = titleDigits[rem] + result;
            cur = (cur - 1) / 26;
        }
        return result;
    }
}