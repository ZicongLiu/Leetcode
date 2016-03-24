public class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int possibilities[] = new int[n + 1];
        possibilities[0] = 1;
        possibilities[1] = 1;
        
        for (int rootVal = 2 ; rootVal <= n ; rootVal ++){
            int sum = 0;
            for (int left = 0 ; left <= rootVal - 1 ; left++){
                int right = rootVal - 1 - left;
                sum += possibilities[left] * possibilities[right];
            }
            possibilities[rootVal] = sum;
        }
        
        return possibilities[n];
    }
}