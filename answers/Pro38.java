public class Solution {
    private String generateNumber(String formerStr){
        String newStr = "";
        
        char compare = formerStr.charAt(0);
        int dupCount = 1;
        for (int idx = 1 ; idx < formerStr.length() ; idx ++){
            while (idx < formerStr.length() && formerStr.charAt(idx) == compare){
                dupCount ++;
                idx ++;
            }
            newStr = newStr + dupCount + compare;
            if (idx < formerStr.length()){
                compare = formerStr.charAt(idx);
                dupCount = 1;
            }
        }
        
        if(dupCount == 1){
            newStr += "1" + compare;
        }
        return newStr;
    }
    
    public String countAndSay(int n) {
        String initialStr = "1";
        while (n > 1){
            initialStr = generateNumber(initialStr);
            n --;
        }
        
        return initialStr;
    }
}