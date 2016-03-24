public class Solution {
    private static final HashMap<Character, Integer> values
     = new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000); 
        }
    };
    public int romanToInt(String s) {
        int sum = 0;
        int prev = -1;
        char[] chars = s.toCharArray();
        for (char c : chars){
            int cur = values.get(c); 
            if (prev != -1 && prev < cur){
                sum += cur - 2 * prev;
            }
            else{
                sum += cur;
            }
            prev = cur;
        }
        return sum;
    }
}