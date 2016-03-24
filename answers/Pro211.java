class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    char val;
    
    public TrieNode(){
        isWord = false;
        for (int childrenIdx = 0 ; childrenIdx < children.length ; childrenIdx++){
            children[childrenIdx] = null;
        }
    }
    
    public TrieNode(char val){
        this();
        this.val = val;
    }
}
public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int idx = 0 ; idx < word.length() ; idx ++){
            int cIdx = word.charAt(idx) - 'a';
            if (cur.children[cIdx] == null){
                cur.children[cIdx] = new TrieNode(word.charAt(idx));
            }
            cur = cur.children[cIdx];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        return match(cur, word, 0);
    }
    
    private boolean match(TrieNode cur , String word, int startIdx){
        boolean result = false;
        
        if (cur == null){
            return false;
        }
        
        if (startIdx >= word.length()){
            return cur.isWord;
        }
        char curCh = word.charAt(startIdx);
         if (curCh == '.'){
            for (TrieNode select : cur.children){
                if (select != null){
                    result = result | match(select, word, startIdx + 1);
                    if (result){
                        return true;
                    }
                }
            }
        }
        else{
            cur = cur.children[curCh - 'a'];
            if (cur == null){
                return false;
            }
            else{
                char compareCh = cur.val;
                if (curCh == compareCh){
                    return match(cur, word, startIdx + 1);
                }
                else{
                    return false;
                }
            }
        }
        
        return result;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");