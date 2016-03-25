public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0){
            return 0;
        }
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        int count = 0;
        for (int i = 1 ; i < nums.length ; i ++){
            sums[i] = sums[i - 1] + nums[i];
            
        }
//        System.out.println("Initial state");
        for (int i = 0 ; i < nums.length ; i ++){
//          System.out.print(nums[i] + " ");
            if (sums[i] >= lower && sums[i] <= upper){
                count ++;
            }
        }
//        System.out.println();
//        System.out.println("After Transformation.");
        return count + mergeSort(sums, 0, sums.length - 1, lower, upper);
    }
    
    private int mergeSort(long[] sums, int startIdx,
     int endIdx, long lower, long upper){
        if (startIdx >= endIdx){
            return 0;
        }
        int midIdx = startIdx + (endIdx - startIdx) / 2;
        
        int count = mergeSort(sums, startIdx, midIdx, lower, upper)
                    + mergeSort(sums, midIdx + 1 , endIdx, lower, upper);
        int lowerIdx = midIdx + 1, upperIdx = midIdx + 1;
        int mergeIdx = midIdx + 1;
        int cacheIdx = 0;
        long cache[] = new long[endIdx - startIdx + 1];
        for (int leftIdx = startIdx ; leftIdx <= midIdx ; leftIdx ++){
            while (lowerIdx <= endIdx
             && sums[lowerIdx] - sums[leftIdx] < lower){
                lowerIdx ++;
            }
            upperIdx = lowerIdx;
            while (upperIdx <= endIdx
             && sums[upperIdx] - sums[leftIdx] <= upper){
                upperIdx ++;
            }
            while (mergeIdx <= endIdx
             && sums[mergeIdx] < sums[leftIdx]){
                cache[cacheIdx ++] = sums[mergeIdx ++];
            }
            count += upperIdx - lowerIdx;
            cache[cacheIdx ++] = sums[leftIdx];
        }
        while (mergeIdx <= endIdx){
            cache[cacheIdx ++] = sums[mergeIdx ++];
        }
        for (int recoverIdx = 0 ;
         recoverIdx < endIdx - startIdx + 1 ; recoverIdx ++){
            sums[recoverIdx + startIdx] = cache[recoverIdx];
        }
//        for (int sum : sums){
//            System.out.print(sum + " ");
//        }
//        System.out.println();
        return count;
    }
}