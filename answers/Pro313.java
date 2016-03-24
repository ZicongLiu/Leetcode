public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        nums[0] = 1;
        int count = 0;
        int plen = primes.length;
        int[] indexes = new int[plen];
        while (count < n - 1){
            int min = Integer.MAX_VALUE;
            for (int i = 0 ; i < plen ; i ++){
                if (min > primes[i] * nums[indexes[i]]){
                    min = primes[i] * nums[indexes[i]];
                }
            }
            for (int i = 0 ; i < plen ; i ++){
                if (min == primes[i] * nums[indexes[i]]){
                    indexes[i] ++;
                }
            }
            count ++;
            nums[count] = min;
        }
        return nums[n - 1];
    }
}