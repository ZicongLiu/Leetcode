public class Solution {
    public int getResult(int num1 , int num2 , char op){
        if (op == '+'){
            return num1 + num2;
        } else if (op == '-'){
            return num1 - num2;
        } else if (op == '*'){
            return num1 * num2;
        } else if (op == '/'){
            return num1 / num2;
        }
        return -1;
    }
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        int idx = 0;
        while (idx < s.length()){
            char curChar = s.charAt(idx);
            while (curChar == ' ' && ++idx < s.length()){
                curChar = s.charAt(idx);
            }
            String numberStr = "";
            while (idx < s.length() && curChar >= '0' && curChar <= '9'){
                numberStr  += curChar;
                idx ++;
                if (idx >= s.length()){
                    break;
                }
                curChar = s.charAt(idx);
            }
            if (numberStr.length() > 0){
                int number = Integer.parseInt(numberStr);
                operands.push(number);
            }
            if (curChar == ' ')
                continue;
            if (curChar == '+' || curChar == '-'
                 || curChar == '*' || curChar == '/'){
                if (operators.isEmpty()){
                    operators.push(curChar);
                } else {
                    // char recentOp = operators.peek();
                    if (curChar == '+' || curChar == '-'){
                        while(!operators.isEmpty()){
                             // calculate numbers in stack first
                            int num2 = operands.pop();
                            int num1 = operands.pop();
                            char op = operators.pop();
                           
                            int result = getResult(num1, num2, op);
                            operands.push(result);
                        }
                        operators.push(curChar);
                    }
                    else if ((curChar == '*' || curChar == '/')){
                        while (!operators.isEmpty()
                         && operators.peek() != '+'
                          && operators.peek() != '-'){
                             // calculate numbers in stack first
                            int num2 = operands.pop();
                            int num1 = operands.pop();
                            char op = operators.pop();
                            int result = getResult(num1, num2, op);
                            operands.push(result);
                        }
                        operators.push(curChar);
                    }
                }
                idx ++;
            }
        }
        while (!operators.isEmpty()){
            int num2 = operands.pop();
            int num1 = operands.pop();
            char op = operators.pop();
            int result = getResult(num1, num2, op);
            operands.push(result);
        }
        return operands.pop();
    }
}