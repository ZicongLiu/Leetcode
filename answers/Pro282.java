public class Solution {
    List<String> result = new ArrayList<String>();
    
    public List<String> addOperators(String num, int target) {
        dfs(num, 0, target, 0, "");
        return result;
    }
    
    public void dfs(String remaining, long cur, int target, long diff,
     String expr){
        if (remaining.length() == 0 && target == cur){
            result.add(expr);
            
            return;
        }
        
        for (int i = 1; i <= remaining.length() ; i++){
            String sub = remaining.substring(0, i);
            // important
            if (sub.length() > 1 && sub.charAt(0) == '0'){
                return;
            }
            String curRem = remaining.substring(i);
            long subNum = Long.parseLong(sub);
            
            if (expr.length() == 0){
                dfs(curRem, subNum ,target , subNum, sub);
            }
            else{
                dfs(curRem, cur + subNum , target, subNum, expr + "+" + sub);
                dfs(curRem, cur - subNum, target, 0 - subNum, expr + "-" + sub);
                dfs(curRem, cur - diff + diff * subNum , target,
                 diff * subNum, expr + "*" + sub);
            }
        }
    }
}