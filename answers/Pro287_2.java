public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
       do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        
        fast = 0;
        int prev = 0;
        
        while(slow != fast){
            prev = slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
        //return nums[prev];
        // Actually, we can return slow directly.
    }
}