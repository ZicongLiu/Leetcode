public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num == 0){
            return result;
        }
        int tail = 1;
        result[0] = 0;
        int count = 0;
        while (tail <= num){
            int prevTail = tail;
            for (int i = 0 ; i < prevTail ; i ++){
                result[tail ++] = result[i] + 1;
                if (tail > num){
                    return result;
                }
            }
        }
        return result;
    }
}