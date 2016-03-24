public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public void dfsCombine(List<Integer> curList, int totalDigit, int curDigit, int totalNumber, int curNumber){
        if (curDigit == totalDigit){
            result.add(new ArrayList(curList));
            return;
        }
        for (int number = curNumber + 1 ; number <= totalNumber; number ++){
            if (curList.size() <= curDigit){
                curList.add(number);    
            }   
            else{
                curList.set(curDigit, number);    
            }
            dfsCombine(curList, totalDigit, curDigit + 1, totalNumber, number);
        }
        
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        
        dfsCombine(list, k , 0, n, 0);
        return result;
    }
}