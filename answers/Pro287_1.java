public class Solution {
    public int findDuplicate(int[] nums) {
        int min = 1, max = nums.length - 1;
        while (min <= max){
            int mid = (min + max) / 2;
            
            int count = 0;
            int countN = 0;
            for (int num : nums){
                if (num <= mid){
                    count ++;
                    
                    if (num == mid){
                        countN ++;                        
                    }
                }
            }
            
            if (countN >= 2){
                return mid;
            }
            
            if (count > mid){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        
        return -1;
    }
}