public class Solution {
    public int lengthLongestPath(String input) {
        int[] lengths = new int[10000];
        int maxLength = -1;
        String[] parts = input.split("\n");
        for (String part: parts){
            char[] lineArr = part.toCharArray();
            int idx = 0;
            while (idx < lineArr.length && lineArr[idx] == '\t'){
                idx ++;
            }
            int remLength = lineArr.length - idx;

            if (isFile(part)){
                int totalLength = 0;
                for (int pIdx = 0 ; pIdx < idx ; pIdx ++){
                    totalLength += lengths[pIdx];
                    totalLength ++;
                }
                totalLength += remLength;
                maxLength = Math.max(maxLength, totalLength);
            }
            else{
                lengths[idx] = remLength;
            }
        }
        return (maxLength == -1) ? 0 : maxLength;
    }
    
    private boolean isFile(String path){
        return (path.indexOf(".") >= 0 && (!path.endsWith(".")));
    }
}