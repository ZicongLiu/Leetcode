public class Solution {
    List<List<Integer>> combinations = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curCombination = new ArrayList<Integer>();
        // curIdx is initially -1 since the array should start iterating from 0
        // and -1 + 1 = 0
        findSum(candidates, target, -1, curCombination);
        return combinations;
    }
    
    private void findSum(int[] candidates, int target, int curIdx,
    List<Integer> curCombination){
        int curSum = 0;
        for (int element : curCombination){
            curSum += element;
        }
        if (target < curSum){
            return;
        }
        if (target == curSum){
            combinations.add(new ArrayList(curCombination));
            return;
        }
        
        for (int idx = curIdx + 1 ; idx < candidates.length ; idx ++){
            curCombination.add(candidates[idx]);
            findSum(candidates, target, idx, curCombination);
            curCombination.remove(curCombination.size() - 1);
            // To avoid duplicates, think of it.
            // For example, 11167,
            // after 1->11->111->1116->11167->1117-> next what?
            // (116..., if we don't add such while loop,
            //           it will continue to add 111...)
            while (idx < candidates.length - 1
                 && candidates[idx] == candidates[idx + 1]){
                idx ++;
            }
        }
    }
}