public class Solution {
    List<String> result = new ArrayList<String>();
    private void dfs(String curStr, int leftRem, int rightRem){
        if (leftRem == 0 && rightRem == 0){
            result.add(curStr);
            return;
        }
        if (leftRem > rightRem){
            return;
        }
        else if (leftRem == rightRem){
            dfs(curStr + "(" , leftRem - 1, rightRem);
        }
        else{
            // leftRem < rightRem
            if (leftRem > 0){
                dfs(curStr + "(", leftRem - 1, rightRem);
            }
            dfs(curStr + ")" , leftRem, rightRem - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        dfs("", n, n);   
        return result;
    }
}