public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> newPerm = new ArrayList<Integer>(); 
        for (int idx = 0 ; idx < nums.length ; idx++){
            newPerm.add(nums[idx]);
        }
        list.add(newPerm);
        while (nextPermutation(nums)){
            newPerm = new ArrayList<Integer>(); 
            for (int idx = 0 ; idx < nums.length ; idx++){
                newPerm.add(nums[idx]);
            }
            list.add(newPerm);
        }
        return list;
    }
    public boolean nextPermutation(int[] nums) {
        int preIdx = -1 , postIdx = -1;
        for (int i = 0 ; i < nums.length - 1 ; i ++){
            if (nums[i] < nums[i + 1]){
                preIdx = i;
            }
        }
        if (preIdx < 0){
            return false;
        }
        for (int i = preIdx + 1; i < nums.length ; i ++){
            if (nums[preIdx] < nums[i]){
                postIdx = i;
            }
        }
        int tmp = nums[preIdx];
        nums[preIdx] = nums[postIdx];
        nums[postIdx] = tmp;
        reverse(nums, preIdx + 1, nums.length - 1);
        return true;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            
            i ++;
            j --;
        }
    }
}