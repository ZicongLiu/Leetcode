public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        findSum(candidates, target, 0, combination);
        
        return result;
    }
    
    public void findSum(int[] candidates, int target, int curIdx,
     List<Integer> curCombination){
        int curSum = 0;
        for (int com : curCombination){
            curSum += com;
        }
        if (curSum > target){
            return;
        }
        if (curSum == target){
            result.add(new ArrayList(curCombination));
            return;
        }
        
        for (int idx = curIdx ; idx < candidates.length; idx ++){
            curCombination.add(candidates[idx]);
            findSum(candidates, target, idx, curCombination);
            curCombination.remove(curCombination.size() - 1);
        }
    }
    
    
}