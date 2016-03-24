public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        if (a.length() < b.length()){
            return addBinary(b, a);
        }
        char[] chA = a.toCharArray();
        char[] chB = b.toCharArray();
        int carry = 0;
        for (int idxA = lenA - 1 ; idxA >= 0 ; idxA--){
            int idxB = idxA - (lenA - lenB);
            int digitA = chA[idxA] - '0';
            int digitB = (idxB < 0) ? 0 : chB[idxB] - '0';          
            int rem = (digitA + digitB + carry) % 2;
            carry = (digitA + digitB + carry) / 2;
            sb.append(String.valueOf(rem));
        }
        if (carry == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}