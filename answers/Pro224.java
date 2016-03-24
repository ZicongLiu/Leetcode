public class Solution {
    
        Stack<String> operators = new Stack<String>();
        Stack<Integer> operands = new Stack<Integer>();
        
    public boolean isOperator(String op){
        return (op.equals("+") || op.equals("-") || op.equals("(") || op.equals(")"));
    }
    
    public int basicCal(String operator){
        int num2 = operands.pop();
        int num1 = operands.pop();
        if (operator.equals("+")){
            return num1 + num2;
        }
        if (operator.equals("-")){
            return num1 - num2;
        }
        return -1;
    }
    public int calculate(String s) {
        
        int idx = 0 ; 
        String entity = "";
        while (idx < s.length()){
            char ch = s.charAt(idx);
            if (ch == ' '){
                idx ++;
                continue;
            }
            String numStr = "";
            while(ch != '+' && ch != '-' && ch != '(' && ch != ')' && ch != ' '
             && idx <= s.length() - 1){
                numStr += ch;
                idx ++;
                if (idx <= s.length() - 1){
                    ch = s.charAt(idx);
                }
            }
            if (numStr.length() > 0){
                operands.push(Integer.parseInt(numStr));
            }
            
            if (isOperator(String.valueOf(ch))){
                if (ch == '('){
                    operators.push(String.valueOf(ch));
                }else if (ch  == ')'){
                    while (!operators.isEmpty() && !operators.peek().equals("(")){
                        String operator = operators.pop();
                        
                        int result = basicCal(operator);
                        operands.push(result);
                    }
                    operators.pop();
                }else{
                    // + or -
                    while (!operators.isEmpty() && (operators.peek().equals("+")
                     || operators.peek().equals("-"))){
                        String operator = operators.pop();
                        
                        int result = basicCal(operator);
                        operands.push(result);
                    }
                    
                    operators.push(String.valueOf(ch));
                }
                    
            }
            
            idx ++;
        }
        
        while (!operators.isEmpty()){
            String operator = operators.pop();
            
            int result = basicCal(operator);
            operands.push(result);
            
        }
        return operands.pop();
    }
}