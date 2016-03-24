public class Solution {
    public String reverseWords(String s) {
        s = reverse(s);
        int curIdx = 0;
        String revStr = "";
        while (curIdx < s.length()) {
            while (curIdx < s.length() && s.charAt(curIdx) == ' ') {
                curIdx++;
            }
            if (curIdx == s.length()) {
                break;
            }
            int startIdx = curIdx;
            while (curIdx < s.length() && s.charAt(curIdx) != ' ') {
                curIdx++;
            }
            int endIdx = curIdx;
            String newPart = reverse(s.substring(startIdx, endIdx));
            revStr += newPart;

            while (curIdx < s.length() && s.charAt(curIdx) == ' ') {
                curIdx++;
            }
            if (curIdx < s.length()) {
                revStr += " ";
            }
        }
        return revStr;
    }

    public String reverse(String s) {
        char[] array = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
        return new String(array);
    }
}