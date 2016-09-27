public class Solution {
    char[] chunks = {'0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public String toHex(int num) {
        String result = "";
        for (int i = 0 ; i < 8 ; i ++){
            int chunk = num & 15;
            num = num >> 4;
            result = chunks[chunk] + result;
            if (num == 0)
                break;
        }
        return result;
    }
}