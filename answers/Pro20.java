public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> pairs
         = new HashMap<Character, Character>(){
            {
                put('(',')');
                put('[',']');
                put('{','}');
            }
        };
        Stack<Character> stack = new Stack<Character>();
        for (int idx = 0; idx < s.length(); idx ++){
            char ch = s.charAt(idx);
            if (pairs.containsKey(ch)){
                stack.push(ch);  
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }
                else{
                    char left = stack.pop();
                    char expRight = pairs.get(left);
                    if (expRight != ch){
                        return false;
                    }
                }
            }
        } 
        if (stack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}