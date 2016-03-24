public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> serialization = new Stack<String>();
        String[] parts = preorder.split(",");
        for (String part : parts){
            if (!part.equals("#")){
                serialization.push(part);
            }
            else{
                if (serialization.isEmpty()
                 || !(serialization.peek().equals("#"))){
                    serialization.push(part);
                }
                else{
                    while (!serialization.isEmpty()
                     && serialization.peek().equals("#")){
                        String sharp = serialization.pop();
                        
                        if (serialization.isEmpty()){
                            return false;
                        }
                        String formerElement = serialization.pop();
                        if (formerElement.equals("#")){
                            return false;
                        }
                    }
                    serialization.push("#");
                }
            }
        }
        
        if (serialization.isEmpty()){
            return false;
        }
        if (!serialization.pop().equals("#")
         || !serialization.isEmpty()){
            return false;
        }
        return true;
    }
}