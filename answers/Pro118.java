public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> oldList = new ArrayList<Integer>();
        if (numRows != 0){
            oldList.add(1);
        }
        result.add(new ArrayList<Integer>(oldList));
        for (int i = 0; i < numRows - 1 ; i ++){
            List<Integer> newList = new ArrayList<Integer>();
            for (int newIdx = 0 ; newIdx < oldList.size() + 1 ; newIdx ++){
                if (newIdx == 0 || newIdx == oldList.size()){
                    newList.add(1);
                }                
                else{
                    newList.add(oldList.get(newIdx - 1) + oldList.get(newIdx));
                }
            }
            
            result.add(new ArrayList<Integer>(newList));
            oldList = newList;
        }
        
        return result;
    }
}