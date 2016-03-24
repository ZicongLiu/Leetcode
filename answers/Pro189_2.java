public class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int last = nums[0];
        k %= nums.length;
        if (k == 0){
            return;
        }
        while (count < nums.length && start < nums.length - 1){
            int cur = start;
            last = nums[cur];
            do{
                int swap = nums[cur];
                nums[cur] = last;
                last = swap;
                cur = (cur + k) % nums.length;
                count ++;
            }while(cur != start);
            nums[start] = last;

            start ++;
        }
    }
}