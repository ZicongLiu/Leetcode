public class Solution {
    public int maxRotateFunction(int[] A) {
        long max = Integer.MIN_VALUE;
        long curSum = 0;
        long totalSum = 0;
        for (int idx = 0 ; idx < A.length ; idx ++){
            curSum += idx * A[idx];
            totalSum += A[idx];
        }
        max = Math.max(max, curSum);
        for (int serial = 0 ; serial < A.length - 1 ; serial ++){
            curSum -= totalSum;
            curSum += A.length * A[serial];
            max = Math.max(curSum, max);
        }
        return (int)max;
    }
}