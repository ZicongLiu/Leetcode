public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> maxList = new ArrayList<Integer>();        
        Arrays.sort(nums);
        
        List[] lists = new ArrayList[nums.length];
        for (int idxNum = 0 ; idxNum < nums.length ; idxNum ++){
            lists[idxNum] = new ArrayList<Integer>();
            lists[idxNum].add(nums[idxNum]);
            for (int idxFormer = 0 ; idxFormer < idxNum ; idxFormer ++){
                if (nums[idxNum] % nums[idxFormer] == 0){
                    if (lists[idxFormer].size() >= lists[idxNum].size()){
                        lists[idxNum] = new ArrayList<Integer>(lists[idxFormer]);
                        lists[idxNum].add(nums[idxNum]);
                    }                
                }
            }
            if (lists[idxNum].size() > maxList.size()){
                maxList = new ArrayList<Integer>(lists[idxNum]);
            }
        }
                
        return maxList;
    }
}