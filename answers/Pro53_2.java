public class Solution {
    public int maxSum(int[] A, int left, int right )
    {
        if( left == right ){
            return A[left];
        }
        int center = (left + right) / 2;
        int maxLeftSum  = maxSum( A, left, center);
        int maxRightSum = maxSum( A, center+1, right);
        
        
        int maxLeft = Integer.MIN_VALUE, tempLeft = 0;
        int maxRight = Integer.MIN_VALUE, tempRight = 0;
        for (int i=center; i>=left; --i){
            tempLeft += A[i];
            if (tempLeft > maxLeft){
                maxLeft = tempLeft;
            }
        }
        for (int i=center+1; i<=right; ++i){
            tempRight += A[i];
            if (tempRight > maxRight){
                maxRight = tempRight;
            }
        }
      
        int maxCenterSum = maxLeft + maxRight;
        
        return maxCenterSum > maxLeftSum ? 
            (maxCenterSum > maxRightSum ?
                 maxCenterSum : maxRightSum) : maxLeftSum > maxRightSum ? 
                    maxLeftSum : maxRightSum;
    }
    
    public int maxSubArray(int[] A){
        int len = A.length;
        return maxSum(A,0,len-1);
    }
}