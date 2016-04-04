class Solution{
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>(); 
        Map<String, Integer> wordIdxs = new HashMap<String, Integer>();
        for (int wordIdx = 0 ; wordIdx < words.length ; wordIdx ++){
            wordIdxs.put(words[wordIdx], wordIdx);
        }
        for (int curIdx = 0 ; curIdx < words.length ; curIdx ++){
            String curStr = words[curIdx];
            // String reverse = new StringBuilder(curStr).reverse().toString();
            for (int splitIdx = 0 ; splitIdx <= curStr.length() ; splitIdx ++){
                String left = curStr.substring(0, splitIdx);
                String right = curStr.substring(splitIdx);
                if (isPalindrome(left)){
                    String rightRev =
                         new StringBuilder(right).reverse().toString();
                    if (wordIdxs.containsKey(rightRev)
                     && wordIdxs.get(rightRev) != curIdx){
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(wordIdxs.get(rightRev));
                        pair.add(curIdx);
                        ret.add(pair);
                    }
                }
                if (isPalindrome(right)){
                    String leftRev
                         = new StringBuilder(left).reverse().toString();
                    if (wordIdxs.containsKey(leftRev) && wordIdxs.get(leftRev)
                     != curIdx && right.length() != 0){
                        List<Integer> pair = new ArrayList<Integer>();
                        pair.add(curIdx);
                        pair.add(wordIdxs.get(leftRev));
                        ret.add(pair);
                    }
                }
            }
        }
        
        return ret;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
}