public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0){
            return "/";
        }
        String result = "";
        Stack<String> stack = new Stack<String>();
        int startIdx = 0;
        
        while (startIdx < path.length() && path.charAt(startIdx) == '/'){
            startIdx ++;
        }
        
        while (startIdx < path.length()){
            int curIdx = startIdx;
            while (curIdx < path.length() && path.charAt(curIdx) != '/'){
                curIdx ++;
            }    
            int endIdx = curIdx;
            String curNode = path.substring(startIdx, endIdx);
            if (!curNode.equals(".")){
                if (curNode.equals("..")){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else{
                    stack.push(curNode);
                }
            }
            while (curIdx < path.length() && path.charAt(curIdx) == '/'){
                curIdx ++;
            }
            startIdx = curIdx;
        }
        Stack<String> resultStack = new Stack<String>();
        while (!stack.isEmpty()){
            resultStack.push(stack.pop());
        }
        while (!resultStack.isEmpty()){
            result += "/";
            result += resultStack.pop();
        }
        if (result.length() == 0){
            result += "/";
        }
        
        return result;
    }
}