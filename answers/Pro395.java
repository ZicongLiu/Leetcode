public class Solution {
    public int longestSubstring(String s, int k) {
        // System.out.println(s);
        char[] sArr = s.toCharArray();
        if (s.length() < k){
            return 0;
        }
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char ch : sArr){
            count[ch - 'a'] ++;
        }
        for (int chIdx = 0 ; chIdx < sArr.length ; chIdx ++){
            if (count[sArr[chIdx] - 'a'] < k){
                return Math.max(
                        longestSubstring(s.substring(0, chIdx), k),
                        longestSubstring(s.substring(chIdx + 1,
                         sArr.length) , k)
                    );
            }
        }
        return sArr.length;
    }
}