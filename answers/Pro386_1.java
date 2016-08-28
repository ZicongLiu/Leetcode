public class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> lexicalOrder(int n) {
        traverse(n, 0);
        return result;
    }
    private boolean traverse(int n, int curNum){
        if (curNum > n){
            return false;
        }
        if (curNum != 0){
            result.add(curNum);
        }
        for (int i = 0 ; i <= 9 ; i++){
            if (curNum == 0 && i == 0){
                continue;
            }
            if (!traverse(n, curNum * 10 + i)){
                break;
            }
        }
        return true;
    }
}