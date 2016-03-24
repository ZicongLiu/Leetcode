public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curCombination = new ArrayList<Integer>(k);
        for (int i = 0 ; i < k ; i++){
            curCombination.add(0);
        }
        findSum(k , 0 , 0 , n, curCombination);
        
        return result;
    }
    private void findSum(int maxDepth, int curDepth,
     int curNum,  int target, List<Integer> curCombination){
        int curSum = 0;
        for (int element : curCombination){
            curSum += element;
        }
        
        if (curSum > target){
            return;
        }
        if (curDepth == maxDepth){
            if (curSum == target){
                result.add(new ArrayList(curCombination));
            }
            return;
        }
            
        for (int num = curNum + 1 ; num <= 9 ; num ++){
            curCombination.set(curDepth, num);
            findSum(maxDepth, curDepth + 1, num, target, curCombination);
            curCombination.set(curDepth, 0);
        }
        
    }
}