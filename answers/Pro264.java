public class Solution {
    public int nthUglyNumber(int n) {
        int nums[] = new int[n];
        nums[0] = 1;
        int idx2 = 0 , idx3 = 0, idx5 = 0;
        int count = 0;
        while (count < n - 1){
            int val2 = nums[idx2];
            int val3 = nums[idx3];
            int val5 = nums[idx5];
            int min = Math.min(Math.min(val2 * 2 , val3 * 3) , val5 * 5);
            if (min == val2 * 2){
                idx2 ++;
            }
            if (min == val3 * 3){
                idx3 ++;
            }
            if (min == val5 * 5){
                idx5++;
            }
            count ++;
            nums[count] = min;
        }
        return nums[n - 1];
    }
}