public class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;
        while (num > 1){
            if (num == 3){
                count += 2;
                break;
            }
            if ((num & 1) == 0){
                num = num >>> 1;
            }
            else if (((num >>> 1) & 1) == 1){
                num ++;
            }
            else{
                num --;
            }
            count ++;
        }
        return count;
    }
}