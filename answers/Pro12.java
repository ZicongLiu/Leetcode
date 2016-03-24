public class Solution {
    private static final String[] romans = { "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I" };
    private static final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40,
            10, 9, 5, 4, 1 };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            int idx = 0;
            while (true){
                while (num < values[idx]){
                    idx ++;
                }
                sb.append(romans[idx]);
                num -= values[idx];
                if (num == 0){
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}