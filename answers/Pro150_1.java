public class Solution {
    public boolean isOperator(String token){
        if (token.equals("+") || token.equals("-") || token.equals("*")
         || token.equals("/")){
            return true;
        } 
        else{
            return false;
        }
    }
    
    public int calculate(int num1, int num2, String token){
        if (token.equals("+")){
            return num1 + num2;
        }
        if (token.equals("-")){
            return num1 - num2;
        }
        if (token.equals("*")){
            return num1 * num2;
        }
        if (token.equals("/")){
            return num1 / num2;
        }
        
        return -1;
    }
    
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String token : tokens){
            if (isOperator(token)){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = calculate(num2, num1, token);
                
                stack.push(String.valueOf(result));
            }
            else{
                stack.push(token);
            }
        }
        
        return Integer.parseInt(stack.pop());
        
    }
}