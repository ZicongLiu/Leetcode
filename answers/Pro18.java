public class Solution {
    public List<List<Integer>> kSum(int k , int[] nums, int target,
     int start, int end){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 2){
            return twoSum(nums, target, start, end);
        }
        else{
            for (int idx = start; idx <= end; idx ++){
                while (idx > start && idx <= end && nums[idx] == nums[idx - 1]){
                    idx ++;
                }
                if (idx > end){
                    break;
                }
                int curEle = nums[idx];
                List<List<Integer>> oldList = kSum(k - 1 , nums,
                 target - curEle, idx + 1, end);
                if (oldList != null){
                    result.addAll(combine(curEle, oldList));
                }
            }
        }
        return (result.size() != 0) ? result : null;
    }
    public List<List<Integer>> twoSum(int[] nums, int target,
     int start, int end){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int idx1 = start;
        int idx2 = end;
        while (idx1 < idx2){
            int val1 = nums[idx1];
            int val2 = nums[idx2];
            int sum = val1 + val2;
            if (sum == target){
                List<Integer> newPair = new ArrayList<Integer>();
                newPair.add(val1);
                newPair.add(val2);
                result.add(newPair);
                idx2 --;
                while(idx2 >= start && idx2 < end
                 && nums[idx2] == nums[idx2 + 1]){
                    idx2 --;
                }
                idx1 ++;
                while (idx1 > start && idx1 <= end
                 && nums[idx1] == nums[idx1 - 1]){
                    idx1 ++;
                }
            }
            else if (sum > target){
                idx2 --;
            }
            else{
                idx1 ++;
            }
        }
        return (result.size() == 0) ? null : result;
    }
    public List<List<Integer>> combine(int ele, List<List<Integer>> oldList){
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for (List<Integer> oldItem : oldList){
            List<Integer> newItem = new ArrayList<Integer>();
            newItem.add(ele);
            newItem.addAll(oldItem);
            newList.add(newItem);
        }
        return newList;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = kSum(4, nums, target, 0, nums.length - 1);
        return result == null ? new ArrayList<List<Integer>>() : result ;
    }
}