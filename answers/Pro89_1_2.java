public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for(int i = 0 ; i < 1<<n ; i++) {
            int temp = i>>1;
            gray.add(i^temp);
        }
        return gray;
    }   
}