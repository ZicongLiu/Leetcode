public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for (int idx = 0 ; idx < input.length() ; idx ++){
            if (input.charAt(idx) == '+' || input.charAt(idx) == '-'
             || input.charAt(idx) == '*'){
                List<Integer> leftResults = 
                    diffWaysToCompute(input.substring(0 , idx));
                List<Integer> rightResults = 
                    diffWaysToCompute(input.substring(idx + 1 , input.length()));
                
                for (int leftResult : leftResults){
                    for (int rightResult : rightResults){
                        switch(input.charAt(idx)){
                            case '+':
                                result.add(leftResult + rightResult);
                                break;
                            case '-':
                                result.add(leftResult - rightResult);
                                break;
                            default:
                                result.add(leftResult * rightResult);
                        }
                    }
                }
            }
        }
        if (result.size() == 0){
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}