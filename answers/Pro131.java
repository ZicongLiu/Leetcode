public class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    
    private boolean isPalindrome(String str){
        int start = 0 , end = str.length() - 1;
        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    private void findPalindrome(String str, int startIdx, List<String> curList){
        if (startIdx == str.length()){
            result.add(new ArrayList(curList));
            return;
        }
        for (int endIdx = startIdx + 1 ; endIdx <= str.length() ; endIdx ++){
            String newStr = str.substring(startIdx, endIdx);
            if (isPalindrome(newStr)){
                curList.add(newStr);
                findPalindrome(str, endIdx, curList);                
                curList.remove(curList.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        findPalindrome(s, 0, new ArrayList<String>());
        return result;
    }
}