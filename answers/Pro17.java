public class Solution {
    String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        traversePhone(digits, 0, new ArrayList<Character>());
        return result;
    }
    
    private void traversePhone(String digits, int depth, List<Character> list){
        if (digits.length() == 0){
            return;
        }
        if (depth == digits.length()){
            String newStr = "";
            for (char ele : list){
                newStr += ele;
            }
            result.add(newStr);
            return;
        }
        String possibilities = mapping[digits.charAt(depth) - '0'];
        if (possibilities.length() == 0){
            return;
        }
        else{
            for (int idx = 0 ; idx < possibilities.length() ; idx ++){
                list.add(possibilities.charAt(idx));
                traversePhone(digits, depth + 1, list);
                list.remove(list.size() - 1);
            }            
        }
        
    }
}