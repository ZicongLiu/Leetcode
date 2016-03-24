public class Solution {
    List<String> result = new ArrayList<String>();
    
    private void findIpAddresses(String s, int startIdx, List<Integer> curList){
        if (startIdx > s.length()){
            return;
        }
        if (curList.size() >= 4 && startIdx < s.length()){
            return;
        }
        if (curList.size() == 4 && startIdx == s.length()){
            result.add(formIpString(curList));
            return;
        }
        
        for (int endIdx = startIdx + 1 ; endIdx <= Math.min(s.length(), startIdx + 3) ; endIdx ++){
            String newNum = s.substring(startIdx, endIdx);
            if (endIdx > startIdx + 1 && s.charAt(startIdx) == '0'){
                return;
            }
            if (Integer.parseInt(newNum) > 255){
                return;
            }
            curList.add(Integer.parseInt(newNum));
            findIpAddresses(s, endIdx, curList);
            curList.remove(curList.size() - 1);
        }
    } 
    
    private String formIpString(List<Integer> list){
        return list.get(0) + "." + list.get(1) + "." + 
            list.get(2) + "." + list.get(3);
    }
    
    public List<String> restoreIpAddresses(String s) {
        findIpAddresses(s, 0, new ArrayList<Integer>());
        return result;
    }
}