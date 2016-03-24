public class Solution {
    public void quickSort(int[] nums , int low, int high){
        if (low < 0 || high > nums.length - 1){
            return ;
        }
        if (low > high){
            return;
        }
        int pivot = nums[low];
        int i = low;
        int j = high;
        
        while (i < j){
            while (i < j && noLessThan(nums[j], pivot)){
                j --;
            }
            nums[i] = nums[j];
            while (i < j && noLessThan(pivot , nums[i])){
                i++;
            }
            nums[j] = nums[i];
        }
        
        nums[i] = pivot;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
    
    public String largestNumber(int[] nums) {
        quickSort(nums, 0 , nums.length - 1);
        
        StringBuilder sb = new StringBuilder();
        
        int idx = nums.length - 1;
        while (idx >= 0 && nums[idx] == 0){
            idx--;
        }
        
        while(idx >= 0){
            sb.append(String.valueOf(nums[idx]));    
            idx --;
        }
        
        
        return sb.toString().length() > 0 ? sb.toString() : "0";
        
    }
    
    public boolean noLessThan(int num1 , int num2){
        String com1 = String.valueOf(num1) + String.valueOf(num2);
        String com2 = String.valueOf(num2) + String.valueOf(num1);
        if (Long.parseLong(com1) >= Long.parseLong(com2)){
            return true;
        }
        
        return false;
    }

}