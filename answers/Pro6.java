public class Solution {
    public String convert(String s, int numRows) {
        String result = "";
        if (s.length() == 0 || numRows <= 1){
            return s;
        }
        for (int row = 0 ; row < numRows ; row ++){
            for (int col = row ; col < s.length() ; col += (numRows - 1) * 2){
                result += s.charAt(col);
                
                if (row != 0 && row != numRows - 1){
                    // except for 1st and last row
                    int right = 2 * row;
                    int left = 2 * (numRows - 1) - right;
                    if (col + left < s.length()){
                        result += s.charAt(col + left);
                    }
                }
            }
        }
            
        return result;
    }
}