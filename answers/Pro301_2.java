public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(s, 0, 0, new char[] {'(',')'}, result);
        return result;
    }
    
    private void dfs(String s, int prevI, int prevJ, char[] flag,
                 List<String> result){
        int halfCnt = 0;
        for (int i = prevI ; i < s.length() ; i ++){
            if (s.charAt(i) == flag[0]){
                halfCnt ++;
            }
            if (s.charAt(i) == flag[1]){
                halfCnt --;
            }
            if (halfCnt >= 0){
                continue;
            }
            for (int j = prevJ ; j <= i ; j ++){
                if (s.charAt(j) == flag[1]
                     && (j == prevJ || flag[1] != s.charAt(j - 1))){
                    dfs(s.substring(0, j) + s.substring(j + 1, s.length()),
                         i, j, flag, result);
                }
            }
            // I don't quite understand why here is a `return` statement
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (flag[0] == '('){
            dfs(reversed, 0, 0, new char[] {')','('}, result);
        } else{
            result.add(reversed);
        }
    }
}