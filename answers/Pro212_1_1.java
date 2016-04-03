
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

public class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0){
            return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                wordSearch(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void wordSearch(char[][] board, int curX, int curY,
     TrieNode curTrie, List<String> res){
        if (curX < 0 || curY < 0
            || curX >= board.length || curY >= board[0].length
            || board[curX][curY] == '#'){
            return;
        }
        
        char curC = board[curX][curY];
        curTrie = curTrie.next[curC - 'a'];
        if (curTrie == null){
            return;
        }
        if (curTrie.word != null){
            res.add(curTrie.word);
            curTrie.word = null;
            // cannot return here! may have a word whose prefix is also a word
            // return;
        }
        board[curX][curY] = '#';
        wordSearch(board, curX + 1, curY, curTrie, res);
        wordSearch(board, curX - 1, curY, curTrie, res);
        wordSearch(board, curX, curY + 1, curTrie, res);
        wordSearch(board, curX, curY - 1, curTrie, res);
                        
        board[curX][curY] = curC;
    }
    
    public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for(String w : words) {
        TrieNode p = root;
        for(char c : w.toCharArray()) {
            int i = c - 'a';
            if(p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}
}