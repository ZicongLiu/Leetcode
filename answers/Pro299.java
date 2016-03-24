public class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        boolean[] visited = new boolean[secret.length()];
        int cntA = 0, cntB = 0;
        for (int i = 0 ; i < secret.length() ; i ++){
            if (secret.charAt(i) == guess.charAt(i)){
                cntA ++;
                visited[i] = true;
            }
            else{
                count[secret.charAt(i) - '0'] ++;
            }
        }
        for (int i = 0 ; i < secret.length() ; i ++){
            if (!visited[i]){
                char guessChar = guess.charAt(i);
                if (count[guessChar - '0'] > 0){
                    count[guessChar - '0']--;
                    cntB ++;
                }
            }
        }
        
        return cntA + "A" + cntB + "B";
    }
}