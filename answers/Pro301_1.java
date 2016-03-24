public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        Set<String> visited = new HashSet<String>();
        Set<String> queueVisited = new HashSet<String>();
        List<String> result = new ArrayList<String>();
        if (isValid(s)){
            result.add(s);
            return result;
        }
        boolean found = false;
        while (!found && !queue.isEmpty()){
            List<String> curLevel = new ArrayList<String>();
            while (!found && !queue.isEmpty()){
                curLevel.add(queue.poll());
            }
            
            for (String cur : curLevel){
                for (int splitIdx = 0 ; splitIdx < cur.length() ; splitIdx ++){
                    if (cur.charAt(splitIdx) != '('
                     && cur.charAt(splitIdx) != ')'){
                        continue;
                    } 
                    String newStr = cur.substring(0, splitIdx)
                                 + cur.substring(splitIdx + 1);
                    if (queueVisited.contains(newStr)){
                        continue;
                    }
                    if (isValid(newStr)){
                        if (!visited.contains(newStr)){
                            visited.add(newStr);
                            result.add(newStr);
                            found = true;
                        }
                    }
                    queueVisited.add(newStr);
                    queue.offer(newStr);
                }
            }
        }
        
        if (result.size() == 0){
            result.add("");
        }
        return result;
    }
    private boolean isValid(String str){
        int count = 0;
        for (int idx = 0 ; idx < str.length() ; idx ++){
            if (str.charAt(idx) == '('){
                count ++;
            }
            if (str.charAt(idx) == ')'){
                if (count == 0){
                    return false;
                }
                count --;
            }
        }
        
        return count == 0;
    }
}