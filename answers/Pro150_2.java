interface Operator{
    public int eval(int a , int b);
}

public class Solution {
    private static final HashMap<String, Operator> cal
     = new HashMap<String, Operator>(){
        {
            put("+" , new Operator(){
                public int eval(int a , int b){
                    return a + b;
                }
            });
            put("-" , new Operator(){
                public int eval(int a , int b){
                    return a - b;
                }
            });
            put("*" , new Operator(){
                public int eval(int a , int b){
                    return a * b;
                }
            });
            put("/" , new Operator(){
                public int eval(int a , int b){
                    return a / b;
                }
            });
        }
    };
    
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens){
            if (cal.containsKey(token)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = cal.get(token).eval(num1, num2);
                
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
        
    }
}